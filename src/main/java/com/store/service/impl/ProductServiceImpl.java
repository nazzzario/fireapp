package com.store.service.impl;

import com.store.dto.request.ProductRequest;
import com.store.dto.response.ProductResponse;
import com.store.mapper.ProductMapper;
import com.store.model.Product;
import com.store.repository.ProductRepository;
import com.store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;


    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> all = productRepository.findAll();
        return all.stream().map(p -> productMapper.toDtoResponse(p)).collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Optional<Product> byId = productRepository.findById(id);
        return byId.map(product -> productMapper.toDtoResponse(product)).orElse(null);
    }

    @Override
    public ProductResponse saveProduct(ProductRequest productRequest) {
        if(productRequest != null){
            Product product = productMapper.requestToEntity(productRequest);
            Product save = productRepository.save(product);
            return productMapper.toDtoResponse(save);
        }

        throw new NullPointerException();
    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest) {
        return null;
    }
}
