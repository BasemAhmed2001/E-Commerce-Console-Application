package org.example.customer;

import org.example.signin.InvalidCreadentialsException;

import static org.example.utils.ProgramInit.customers;

public class CustomerService {





    public static Customer findCustomerByUsername(String userName){

        Customer customer = customers.stream()
                .filter(c-> c.getUserName().equals(userName))
                .findFirst().orElseThrow(() -> new InvalidCreadentialsException("Username or Password is not correct!"));

        return customer;

    }

    public static Customer findCustomerById(int id){

        Customer customer = customers.stream()
                .filter(c-> (c.getId() == id))
                .findFirst()
                .get();

        return customer;

    }


    public static void helloCustomer(Customer customer){
        String[] fullName = customer.getFullName().split(" ");
        System.out.println("Hello " + fullName[0]);
    }



}
