package org.example.utils;

import org.example.product.Expirable;
import org.example.product.Product;
import org.example.product.Shippable;

import java.time.LocalDate;

public class GenericProduct extends Product implements Shippable, Expirable {

    private LocalDate expireDate;
    private double weight = 0;
    public static final LocalDate NOT_EXPIRABLE = LocalDate.MAX;
    public static final double NOT_SHIPPABLE = 0.00;
    public static final LocalDate _1_1_2025 = LocalDate.of(2025,1,1);
    public static final LocalDate _1_1_2026 = LocalDate.of(2026,1,1);
    public static final LocalDate _1_1_2027 = LocalDate.of(2027,1,1);

    public GenericProduct(String name, double price, int quantity, LocalDate expireDate, double weight) {
        super(name, price, quantity);
        this.expireDate = expireDate;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return expireDate.isBefore(LocalDate.now());
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return  "     " + getName() + "     " +
                "     " + getPrice() + "     " +
                "     " + getQuantity() + "     "
                ;
    }
}
