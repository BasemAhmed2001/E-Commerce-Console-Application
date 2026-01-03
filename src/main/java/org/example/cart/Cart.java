package org.example.cart;

import org.example.utils.GenericProduct;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    int customerId;
    Map<GenericProduct, Integer> products = new HashMap<GenericProduct, Integer>();


    public Cart(int  customerId) {
        this.customerId = customerId;
    }


    public boolean isEmpty(){
        return products.isEmpty();
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Map<GenericProduct, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<GenericProduct, Integer> products) {
        this.products = products;
    }





}
