package com.sanedge.ecommercequery.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemRequest {
    private Long productId;
    private int quantity;
    private double price;
}