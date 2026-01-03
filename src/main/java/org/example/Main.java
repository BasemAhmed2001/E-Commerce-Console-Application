package org.example;

import org.example.cart.CartService;
import org.example.checkout.CheckOutService;
import org.example.checkout.CheckOutInfoDto;
import org.example.customer.CustomerDto;
import org.example.cart.Cart;
import org.example.shipping.ShippingService;
import org.example.utils.ProgramInit;

import java.util.Scanner;

import static org.example.common.GlobalExceptionHandling.handleException;
import static org.example.product.ProductService.displayProducts;
import static org.example.signin.SignInService.signIn;



public class Main {


    public static void main(String[] args) {


        ProgramInit.init();
        System.out.println("____________   HELLO TO OUR SHOP   ____________");
        while(true){

           try {
               System.out.println("\n1. Sign in \t \t 2. Exit");
               Scanner scanner = new Scanner(System.in);
               int input = scanner.nextInt();
               switch (input){
                   case 1:
                       break;
                   case 2:
                       System.exit(0);
                   default:
                       System.out.println("Invalid input");
                       continue;
               }

               CustomerDto customerDto = signIn();
               Cart cart = new Cart(customerDto.getId());
               CartService cartService = new CartService(cart);
               ShippingService shippingService = new ShippingService(cart);
               CheckOutService checkOutService = new CheckOutService(cart);



               boolean signedIn = true;
               CheckOutInfoDto checkOutInfoDto;
               displayProducts();
               while(signedIn){


                   try {

                       System.out.println("\n1. Add product to cart \t 2. Display cart \t 3. Checkout \t 4. Logout \t 5. Remove product");
                       Scanner scan = new Scanner(System.in);
                       int in = scan.nextInt();
                       switch (in){
                           case 1:
                               cartService.saveProductToCart();
                               continue;
                           case 2:
                               cartService.displayCart();
                               continue;
                           case 3:
                               checkOutInfoDto = checkOutService.checkOut(shippingService.getShippingInfo());
                               break;
                           case 4:
                               signedIn = false;
                               continue;
                           case 5:
                               cartService.removeProductFromCart();
                               continue;
                           default:
                               System.out.println("Invalid input");
                               continue;
                       }
                       checkOutService.displayCheckoutReceipt(checkOutInfoDto);
                       cart = new Cart(customerDto.getId());
                       cartService = new CartService(cart);
                       shippingService = new ShippingService(cart);
                       checkOutService = new CheckOutService(cart);
                       System.out.println("1. Continue shopping \t 2. Log out \t 3. Exit");
                       int op = scanner.nextInt();
                       switch (op){
                           case 1:
                               continue;
                           case 2:
                               signedIn = false;
                               continue;
                           case 3:
                               System.exit(0);
                       }

                   } catch (RuntimeException e) {
                       handleException(e);
                   }
               }

           } catch (RuntimeException e) {
               handleException(e);
           }




       }


    }
}