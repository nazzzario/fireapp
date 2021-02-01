package com.store.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductResponse implements Serializable {
    private String name;
    // todo fix price value
    private int price;
    private String photoLink;
}
