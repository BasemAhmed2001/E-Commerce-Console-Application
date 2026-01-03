package org.example.product;

public class ProductOutOfStockException extends RuntimeException{


    public ProductOutOfStockException(String message){
        super(message);
    }

}
