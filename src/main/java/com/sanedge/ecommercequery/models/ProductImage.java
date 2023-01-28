package com.sanedge.ecommercequery.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class ProductImage extends FileUpload {
    @ManyToOne(fetch = FetchType.LAZY)
    Product product;
}
