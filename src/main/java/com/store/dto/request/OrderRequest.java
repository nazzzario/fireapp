package com.store.dto.request;

import com.store.model.Person;
import com.store.model.Product;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderRequest implements Serializable {
    private String orderDescription;
    private Person person;
    private Product productId;
}
