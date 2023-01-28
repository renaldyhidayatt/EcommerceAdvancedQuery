package com.sanedge.ecommercequery.dto.response;

import java.time.ZonedDateTime;
import java.util.List;

import com.sanedge.ecommercequery.models.CategoryImage;
import com.sanedge.ecommercequery.models.Product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryResponse {
    private Long id;
    private String name;
    private String description;
    private List<Product> products;
    private List<CategoryImage> images;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
