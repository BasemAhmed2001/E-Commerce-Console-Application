package org.example.signin;

import org.example.customer.CustomerDto;
import org.example.customer.Customer;

import java.util.Scanner;

import static org.example.signin.ValidationService.validateUsernamePassword;
import static org.example.customer.CustomerService.helloCustomer;

public class SignInService {



    public static CustomerDto signIn(){




        System.out.println("\nEnter username and password");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username:");
        String username = scanner.nextLine().toLowerCase().trim();
        System.out.println("Password:");
        String password = scanner.nextLine().toLowerCase().trim();

        Customer customer = validateUsernamePassword(username,password);

        helloCustomer(customer);
        return new CustomerDto(customer.getId(), customer.getFullName());

    }




}
