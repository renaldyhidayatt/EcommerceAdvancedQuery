package com.sanedge.ecommercequery.dto.response;

import java.util.List;

import com.sanedge.ecommercequery.models.Product;
import com.sanedge.ecommercequery.models.TagImage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TagResponse {
    private String name;

    private String description;

    private List<Product> products;

    private List<TagImage> images;
}
