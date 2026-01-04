package org.example.product;

import org.example.utils.GenericProduct;
import org.example.utils.ProgramInit;

import java.util.List;

public class ProductService {



    public static void displayProducts(){
        List<GenericProduct> l = ProgramInit.products.stream().filter(p -> p.getQuantity() != 0).toList();
        String format = "%15s  | %15s  | %15s  |\n";
        System.out.println("_ ".repeat(28));
        System.out.printf(format,"Product","Price", "Quantity");
        System.out.println("_ ".repeat(28));
        for(GenericProduct g:l){
            System.out.printf(format,g.getName(),g.getPrice(),g.getQuantity());
        }
        System.out.println("_ ".repeat(28));

    }


    public static GenericProduct findProductByName(String name){

        return ProgramInit.products
                .stream()
                .filter(p -> p.getName().equals(name))
                .findAny().orElseThrow( () -> new ProductNotFoundException("Product with name:" + name + " not found"));

    }

    public static void reduceProductQuantity(GenericProduct product, int quantity){
        product.setQuantity(product.getQuantity() - quantity);
    }


}
