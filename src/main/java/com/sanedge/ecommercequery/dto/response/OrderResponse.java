package com.sanedge.ecommercequery.dto.response;

import java.time.ZonedDateTime;
import java.util.Collection;

import com.sanedge.ecommercequery.enums.OrderStatus;
import com.sanedge.ecommercequery.models.OrderItem;

import lombok.Data;

@Data
public class OrderResponse {
    private Long id;
    private String trackingNumber;
    private OrderStatus orderStatus;
    private AddressResponse address;
    private Collection<OrderItem> orderItems;
    private double total;
    private Long orderItemsCount;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
