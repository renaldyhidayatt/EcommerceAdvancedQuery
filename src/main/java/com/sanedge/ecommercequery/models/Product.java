package com.sanedge.ecommercequery.models;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "products")
public class Product extends Timestamped {
        @Column(nullable = false)
        public String name;

        protected String description;

        @Column(unique = true)
        public String slug;

        protected double price;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.REMOVE)
        private Collection<Comment> comments = new ArrayList<>();

        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
        @JoinTable(name = "products_tags", joinColumns = {
                        @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id") }, inverseJoinColumns = {
                                        @JoinColumn(name = "tag_id", nullable = false, referencedColumnName = "id") })
        protected Set<Tag> tags = new HashSet<>();

        @LazyCollection(LazyCollectionOption.FALSE)

        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
        @JoinTable(name = "products_categories", joinColumns = {
                        @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id") }, inverseJoinColumns = {
                                        @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
                        })
        protected Set<Category> categories = new HashSet<>();

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.REMOVE)
        private Collection<Comment> orderItems = new ArrayList<>();

        @Column(nullable = false)
        protected ZonedDateTime publishOn;

        protected int stock;

        @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        protected Collection<ProductImage> images;
}
