package org.example.common;

import org.example.cart.CartEmptyException;
import org.example.customer.InSufficientBalance;
import org.example.product.NotEnoughQuantityException;
import org.example.product.ProductNotFoundException;
import org.example.product.ProductOutOfStockException;
import org.example.signin.InvalidCreadentialsException;

import java.util.logging.Logger;

public class GlobalExceptionHandling {


    public static void handleException(RuntimeException ex){

        Logger logger = Logger.getLogger(GlobalExceptionHandling.class.getName());

        if(ex instanceof ProductOutOfStockException){
            System.out.println(ex.getMessage());
        }
        else if(ex instanceof CartEmptyException){

            System.out.println(ex.getMessage());
        }else if(ex instanceof NotEnoughQuantityException){
            System.out.println(ex.getMessage());
        }else if(ex instanceof InSufficientBalance){
            System.out.println(ex.getMessage());
        } else if (ex instanceof InvalidCreadentialsException) {
            System.out.println(ex.getMessage());
        } else if (ex instanceof InputMismatchException) {
            logger.info("Invalid Input");
            System.out.println("Invalid Input");
        } else if (ex instanceof ProductNotFoundException) {
            System.out.println(ex.getMessage());
        }


    }



}
