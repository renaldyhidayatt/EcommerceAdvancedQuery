package com.sanedge.ecommercequery.models;

import java.util.Collection;

import com.sanedge.ecommercequery.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "orders")
public class Order extends Timestamped {
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    String trackingNumber;

    @Enumerated
    OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    Collection<OrderItem> orderItems;

    @Transient
    double total;

    @Transient
    private Long orderItemsCount;
}
