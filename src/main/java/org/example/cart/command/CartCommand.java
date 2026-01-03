package org.example.cart.command;

import org.example.cart.Cart;

public interface CartCommand {


    public void execute(String productName, int quantity);
}
