package com.store.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonRequest implements Serializable {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
}
