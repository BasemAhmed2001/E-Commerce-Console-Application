package org.example.shipping;

import java.util.List;

public class ShippingInfoDto {



    public List<ShippingItemDto> shippingItems;
    double totalWeight;
    double shippingFees;


    public ShippingInfoDto(List<ShippingItemDto> shippingItems, double totalWeight, double shippingFees) {
        this.shippingItems = shippingItems;
        this.totalWeight = totalWeight;
        this.shippingFees = shippingFees;
    }

    public double getShippingFees() {
        return shippingFees;
    }

    public void setShippingFees(double shippingFees) {
        this.shippingFees = shippingFees;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }


    @Override
    public String toString() {
        return  "\n" + "ShippingInfoDto{" +
                "shippingItems=" + shippingItems + "\n" +
                ", totalWeight=" + totalWeight +  "\n" +
                ", shippingFees=" + shippingFees +
                '}';
    }
}
