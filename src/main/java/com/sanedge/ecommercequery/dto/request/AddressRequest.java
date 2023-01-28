package com.sanedge.ecommercequery.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressRequest {
    @NotBlank
    @Size(min = 7, max = 10)
    private String firstName;
    @NotBlank
    @Size(min = 7, max = 10)
    private String lastName;
    @NotBlank
    @Size(min = 7, max = 30)
    private String address;
    @NotBlank
    @Size(min = 7, max = 30)
    private String city;
    @NotBlank
    @Size(min = 7, max = 30)
    private String country;
    @NotBlank
    @Size(min = 5, max = 10)
    private String zipCode;
    @NotBlank
    private Long userId;
}
