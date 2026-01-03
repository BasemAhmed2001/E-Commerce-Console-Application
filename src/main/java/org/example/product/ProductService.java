package org.example.product;

import org.example.utils.GenericProduct;
import org.example.utils.ProgramInit;

import java.util.List;

public class ProductService {



    public static void displayProducts(){
        List<GenericProduct> l = ProgramInit.products.stream().filter(p -> p.getQuantity() != 0).toList();
        System.out.println("    Product    |    Price    |    Quantity    \n");
        for(GenericProduct g:l){
            System.out.println(g);
        }

    }


    public static GenericProduct findProductByName(String name){

        GenericProduct product = ProgramInit.products
                .stream()
                .filter(p -> p.getName().equals(name))
                .findAny().orElseThrow( () -> new ProductNotFoundException("Product not found"));

        return product;
    }

    public static void reduceProductQuantity(GenericProduct product, int quantity){
        product.setQuantity(product.getQuantity() - quantity);
    }


}
