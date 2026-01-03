package org.example.utils;

import org.example.cart.validator.CartValidator;
import org.example.cart.validator.QuantityValidator;
import org.example.cart.validator.StockValidator;
import org.example.customer.Customer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProgramInit {

    public static List<GenericProduct> products;
    public static Set<Customer> customers;

    public static void init(){
        products = new ArrayList<GenericProduct>();
        customers = new HashSet<Customer>();
        products.add(new GenericProduct("cheese", 25, 5,GenericProduct._1_1_2026,0.25 ));
        products.add(new GenericProduct("tv", 1300, 2,GenericProduct.NOT_EXPIRABLE,20 ));
        products.add(new GenericProduct("biscuits", 5, 10,GenericProduct._1_1_2027,0.01 ));
        products.add(new GenericProduct("mobile", 4000, 1,GenericProduct.NOT_EXPIRABLE,1 ));
        products.add(new GenericProduct("scratchcard", 10, 15,GenericProduct.NOT_EXPIRABLE,GenericProduct.NOT_SHIPPABLE ));
        customers.add(new Customer(1, "Basem Ahmed", "basem522001", "12345", 10000));
        customers.add(new Customer(2, "Ahmed Shehata", "ahmed", "6789", 500));
    }


    public static List<CartValidator> createValidators(){

        List<CartValidator> validators = new ArrayList<>();
        validators.add(new QuantityValidator());
        validators.add(new StockValidator());
        return validators;

    }




}
