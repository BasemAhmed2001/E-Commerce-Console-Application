package org.example.cart;

import org.example.cart.command.CartCommand;
import org.example.cart.command.SaveProductInCartCommand;
import org.example.cart.validator.CartValidator;
import org.example.cart.validator.QuantityValidator;
import org.example.cart.validator.StockValidator;
import org.example.product.NotEnoughQuantityException;
import org.example.product.ProductExpiredException;
import org.example.product.ProductNotFoundException;
import org.example.product.ProductOutOfStockException;
import org.example.utils.GenericProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.example.product.ProductService.*;
public class CartService {

    Cart cart;
    List<CartValidator> validators =  List.of(new StockValidator(), new QuantityValidator());

    public CartService(Cart cart) {
        this.cart=cart;
    }








    public void saveProductToCart(){
        CartCommand cartCommand = new SaveProductInCartCommand(cart, validators);
        displayProducts();
        System.out.println("Enter name of product:");
        Scanner sc = new Scanner(System.in);
        String productName = sc.nextLine().trim().toLowerCase();
        System.out.println("Enter quantity:");
        int quantity =  sc.nextInt();
        cartCommand.execute(productName, quantity);
        System.out.println(quantity + "x " + productName + " added to cart.");

    }

    public boolean isEmpty(){

        return cart.getProducts().isEmpty();
    }


    public void displayCart(){

        if(cart.isEmpty()){
            throw new CartEmptyException("Cart is empty");
        }
        Map<GenericProduct, Integer> products = cart.getProducts();
        System.out.println("******  Cart Content  ******");
        for(Map.Entry<GenericProduct, Integer> p : products.entrySet()){
            System.out.println(p.getValue() + "x   " + p.getKey().getName());
        }


    }





    public void removeProductFromCart(){
        displayCart();
        System.out.println("Enter name of product to remove:");
        Scanner sc = new Scanner(System.in);
        String productName = sc.nextLine().trim().toLowerCase();
        System.out.println("Enter quantity to remove:");
        int quantity =  sc.nextInt();
        Map.Entry<GenericProduct, Integer> p = findProductInCartByName(productName);
        if(p.getValue() <= quantity){
            GenericProduct item = p.getKey();
            cart.getProducts().remove(item);
        } else {
            reduceQuantityInCart(productName,quantity);
        }
        System.out.println(quantity + "x " +productName + " removed from cart");
    }


    public GenericProduct reduceQuantityInCart(String productName, int quantity){
        Map.Entry<GenericProduct, Integer> cartProduct = cart.getProducts()
                .entrySet()
                .stream()
                .filter(p -> {
                    if(p.getKey().getName().equals(productName)){
                        p.setValue(p.getValue() - quantity);
                        return true;
                    }else{
                        return false;
                    }

                })
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(productName + " not found"));

        return cartProduct.getKey();


    }


    public Map.Entry<GenericProduct, Integer> findProductInCartByName(String productName){
        Map.Entry<GenericProduct, Integer> cartProduct = cart.getProducts()
                .entrySet()
                .stream()
                .filter(p -> p.getKey().getName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product with name:" + productName + " not found"));
        return cartProduct;
    }


    public boolean isProductExistInCart(String productName){
        return cart.getProducts()
                .entrySet()
                .stream()
                .anyMatch(p -> p.getKey().getName().equals(productName));

    }

}
