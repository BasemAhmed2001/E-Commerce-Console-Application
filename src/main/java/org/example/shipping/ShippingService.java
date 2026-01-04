package org.example.shipping;

import org.example.cart.Cart;
import org.example.utils.GenericProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShippingService {


    Cart cart;
    public static final double RATE_FOR_KG = 20.0;

    public ShippingService(Cart cart) {
        this.cart = cart;
    }




    public ShippingInfoDto getShippingInfo(){

        List<ShippingItemDto> shippingItems = new ArrayList<>();
        double totalWeight = 0.00;
        for(Map.Entry<GenericProduct, Integer> product : cart.getProducts().entrySet()){
            if(product.getKey().getWeight() != 0.00){
                totalWeight += (product.getKey().getWeight() * (double)product.getValue());
                shippingItems.add(new ShippingItemDto(product.getKey().getName()
                                                    ,product.getValue()
                                                    ,product.getKey().getWeight()
                ));

            }
        }
        double totalPrice = Math.ceil(totalWeight) * RATE_FOR_KG;

        ShippingInfoDto shippingInfoDto = new ShippingInfoDto(shippingItems, totalWeight,totalPrice );

        return shippingInfoDto;

    }



}
