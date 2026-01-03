package org.example.checkout;


import org.example.product.NotEnoughQuantityException;
import org.example.shipping.ShippingInfoDto;
import org.example.cart.CartEmptyException;
import org.example.customer.InSufficientBalance;
import org.example.cart.Cart;
import org.example.customer.Customer;
import org.example.utils.GenericProduct;
import org.example.utils.ProgramInit;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.example.common.GlobalExceptionHandling.handleException;
import static org.example.customer.CustomerService.findCustomerById;

public class CheckOutService {


    Cart cart;

    public CheckOutService(Cart cart) {
        this.cart = cart;
    }

    public double calculateSubTotal(){

        if(cart.isEmpty()){
            handleException(new CartEmptyException("Cart with customer id: " + cart.getCustomerId() + " is Empty"));
        }
        double subTotal = 0;
        Map<GenericProduct, Integer> products = cart.getProducts();

        for(Map.Entry<GenericProduct, Integer> p : products.entrySet()){
            subTotal += p.getKey().getPrice();
        }

        return subTotal;

    }


    public CheckOutInfoDto checkOut(ShippingInfoDto shippingInfoDto){

        if(cart.isEmpty()){
            throw new CartEmptyException("Cart with customer id: " + cart.getCustomerId() + " is Empty");
        }

        double subTotal = calculateSubTotal();
        Map<GenericProduct, Integer> products = cart.getProducts();

        for(Map.Entry<GenericProduct, Integer> p : products.entrySet()){
            for(GenericProduct inventoryProduct : ProgramInit.products){
                if(p.getKey().getName().equals(inventoryProduct.getName())){
                    if(p.getValue() > inventoryProduct.getQuantity()){
                        throw new NotEnoughQuantityException("Amount (" + p.getValue() +") required is not available, try another quantity");
                    }
                    inventoryProduct.setQuantity(inventoryProduct.getQuantity() - p.getValue());
                }
            }
        }


        double total = subTotal + shippingInfoDto.getShippingFees();
        Customer customer = findCustomerById(cart.getCustomerId());
        if(customer.getBalance() < total){
            throw new InSufficientBalance("Your balance is insufficient to pay: " + total + " EGP");
        }
        customer.setBalance(customer.getBalance() - total);

        return new CheckOutInfoDto(shippingInfoDto, getCheckOutItems(), subTotal, total);
    }



    public List<CheckOutItemDto> getCheckOutItems(){
        Map<GenericProduct, Integer> products = cart.getProducts();
        List<CheckOutItemDto> itemsList = new ArrayList<CheckOutItemDto>();
        for(Map.Entry<GenericProduct, Integer> p : products.entrySet()){
            itemsList.add(new CheckOutItemDto(p.getKey().getName(), p.getValue(), p.getKey().getPrice()));
        }
        return itemsList;
    }


    public void displayCheckoutReceipt(CheckOutInfoDto info){

        String format = "%-15s %5s %10s%n";
        System.out.println("********  CASH RECEIPT  ********");
        System.out.println("ـ".repeat(33) );
        System.out.println("         Shipping Info        ");
        System.out.println("ـ".repeat(33) );
        System.out.printf(format ,"Item", "Qty", "Weight");
        info.shippingInfoDto.shippingItems
                .forEach(i ->
                        System.out.printf(format, i.getProductName(),i.getQuantity(), i.getWeight()));
        System.out.println("\nTotal Weight:\t" + info.shippingInfoDto.getTotalWeight() + "Kg");
        System.out.println("ـ".repeat(33) );
        System.out.println("         Check-out Info        ");
        System.out.printf(format ,"Item", "Qty", "Price");
        info.checkOutItemDtoList
                .forEach(i ->
                        System.out.printf(format, i.getProductName(), i.getQuantity(), i.getPrice()));
        System.out.println("ـ".repeat(33) );
        System.out.printf("Subtotal: %22s", info.subTotal);
        System.out.printf("\nShipping fees: %17s", info.getShippingInfoDto().getShippingFees());
        System.out.printf("\nTotal: %24s\n", info.total);
    }



}
