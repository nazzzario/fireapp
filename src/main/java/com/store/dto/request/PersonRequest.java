package com.store.dto.request;

import lombok.Data;

@Data
public class PersonRequest {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
}
