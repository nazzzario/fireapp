package com.store.service;

import com.store.dto.request.ProductRequest;
import com.store.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);

    ProductResponse saveProduct(ProductRequest product);

    ProductResponse update(Long id, ProductRequest productRequest);

    void deleteProductById(Long id);
}
