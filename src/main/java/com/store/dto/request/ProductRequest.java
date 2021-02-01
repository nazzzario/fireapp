package com.store.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductRequest implements Serializable {
    private String name;
    // todo fix price value
    private int price;
    private int amount;
    private String photoLink;
}
