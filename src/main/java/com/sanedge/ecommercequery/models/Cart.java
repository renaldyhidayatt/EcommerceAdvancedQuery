package com.sanedge.ecommercequery.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cart {
    private int quantity;
    private Product product;

    public double getTotalAmount() {
        return getQuantity() * getPrice();
    }

    private double getPrice() {
        return product.getPrice();
    }

}
