package com.sanedge.ecommercequery.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class RoleResponse {
    private String name;
    private String description;
    private List<UserResponse> users;

}
