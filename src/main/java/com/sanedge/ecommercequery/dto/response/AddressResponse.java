package com.sanedge.ecommercequery.dto.response;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String country;
    private String zipCode;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
