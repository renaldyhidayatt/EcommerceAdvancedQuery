package com.sanedge.ecommercequery.dto.response;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemResponse {
    private Long id;
    private String productName;
    private String productSlug;
    private double price;
    private int quantity;
    private double total;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
