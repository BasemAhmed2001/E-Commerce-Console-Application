package org.example.cart.command;

import org.example.cart.Cart;
import org.example.cart.validator.CartValidator;
import org.example.utils.GenericProduct;

import java.util.List;

import static org.example.product.ProductService.findProductByName;

public class SaveProductInCartCommand implements CartCommand{


    Cart cart;
    List<CartValidator> validators;


    public SaveProductInCartCommand(Cart cart, List<CartValidator> validators){
        this.cart = cart;
        this.validators = validators;
    }


    @Override
    public void execute(String productName, int quantity) {

        GenericProduct product = findProductByName(productName);

        validators.forEach((validator)-> validator.validate(product, quantity));

        int currentQuantity = cart.getProducts().getOrDefault(product, 0);

        cart.getProducts().put(product, currentQuantity + quantity);

    }
}
