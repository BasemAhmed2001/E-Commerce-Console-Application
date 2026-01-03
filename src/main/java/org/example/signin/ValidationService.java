package org.example.signin;

import org.example.customer.Customer;

import static org.example.utils.ProgramInit.customers;

public class ValidationService {


    public static Customer validateUsernamePassword(String username, String password) {

        Customer customer = customers.stream()
                .filter(c-> c.getUserName().equals(username))
                .findFirst().orElseThrow(() -> new InvalidCreadentialsException("Username or Password is not correct!"));

        if(!(customer.getPassword().equals(password) && customer.getUserName().equals(username))) {
            throw new InvalidCreadentialsException("Username or Password is not correct!");
        }
        return customer;
    }


}
