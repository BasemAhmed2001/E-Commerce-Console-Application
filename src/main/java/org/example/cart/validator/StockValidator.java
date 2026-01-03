package org.example.cart.validator;

import org.example.product.ProductOutOfStockException;
import org.example.utils.GenericProduct;

public class StockValidator implements CartValidator {


    public  void validate(GenericProduct genericProduct, int quantity) {

        if(genericProduct.getQuantity() <= 0 ){
            throw new ProductOutOfStockException(genericProduct.getName() + " is out of stock right now");
        }
    }


}
