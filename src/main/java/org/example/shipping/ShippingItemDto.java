package org.example.shipping;

public class ShippingItemDto {

    String productName;
    int quantity;
    double weight;


    public ShippingItemDto(String productName, int quantity, double weight) {
        this.productName = productName;
        this.quantity = quantity;
        this.weight = weight;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "\n" + "ShippingItemDto{" +
                "productName='" + productName +
                ", quantity=" + quantity +
                ", weight=" + weight +
                '}';
    }
}
