package com.sanedge.ecommercequery.models;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table
public class Address extends Timestamped {

    public String address;
    private String city;
    private String country;
    private String zipCode;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "address")
    Collection<Order> orders;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
