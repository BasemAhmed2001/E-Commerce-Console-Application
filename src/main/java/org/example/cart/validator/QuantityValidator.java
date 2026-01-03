package org.example.cart.validator;

import org.example.product.NotEnoughQuantityException;
import org.example.utils.GenericProduct;

public class QuantityValidator implements CartValidator{


    @Override
    public void validate(GenericProduct genericProduct, int quantity) {
        if(quantity > genericProduct.getQuantity()){
            throw new NotEnoughQuantityException("Amount (" + quantity +") required is not available, try another quantity");
        }
    }
}
