package com.store.dto.response;
import lombok.Data;

import java.io.Serializable;

@Data
public class PersonResponse implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
