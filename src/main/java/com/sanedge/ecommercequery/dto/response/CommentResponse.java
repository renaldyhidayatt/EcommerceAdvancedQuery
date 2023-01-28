package com.sanedge.ecommercequery.dto.response;

import java.time.ZonedDateTime;

import com.sanedge.ecommercequery.models.Product;
import com.sanedge.ecommercequery.models.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentResponse {
    private String content;

    private User user;

    private Product product;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;
}
