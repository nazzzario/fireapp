package com.store.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ProductResponse implements Serializable {
    private String name;
    // todo fix price value
    private int price;
    private String photoLink;
}
