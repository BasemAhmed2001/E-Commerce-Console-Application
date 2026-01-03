package org.example.cart.validator;

import org.example.utils.GenericProduct;

public interface CartValidator {

    public void validate(GenericProduct genericProduct, int quantity);


}
