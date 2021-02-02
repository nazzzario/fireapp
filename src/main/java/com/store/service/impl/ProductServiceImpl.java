package com.store.service.impl;

import com.store.dto.request.ProductRequest;
import com.store.dto.response.ProductResponse;
import com.store.mapper.ProductMapper;
import com.store.model.Product;
import com.store.repository.ProductRepository;
import com.store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
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
    public ProductResponse update(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow(NullPointerException::new);
        Product updated = productMapper.requestToEntity(productRequest, product);
        return productMapper.toDtoResponse(productRepository.save(updated));
    }


    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id)
                .orElseThrow(NullPointerException::new);
        productRepository.deleteById(id);
    }
}
