package com.sanedge.ecommercequery.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "categories")
public class Category extends Timestamped {
    @Column(nullable = false, unique = true)
    protected String name;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<CategoryImage> images = new ArrayList<>();
}
