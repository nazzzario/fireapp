package com.store.dto.response;

import com.store.model.Person;
import com.store.model.Product;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderResponse implements Serializable {
    private String orderDescription;
    private Person person;
    private List<Product> product;

}
