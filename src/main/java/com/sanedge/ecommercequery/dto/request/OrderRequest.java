package com.sanedge.ecommercequery.dto.request;

import java.util.List;

import com.sanedge.ecommercequery.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderRequest {
    private Long userId;
    private String trackingNumber;
    private OrderStatus orderStatus;
    private AddressRequest address;
    private List<OrderItemRequest> orderItems;
}
