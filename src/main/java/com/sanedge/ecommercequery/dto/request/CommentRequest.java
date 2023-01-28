package com.sanedge.ecommercequery.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentRequest {
    private String content;
    private Long userid;
    private Long productid;
}
