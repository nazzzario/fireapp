package com.store.controller;


import com.store.dto.request.ProductRequest;
import com.store.dto.response.ProductResponse;
import com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")

public class HelloController {

    private ProductService productService;

    @Autowired
    public HelloController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String sayHello(){
        return "Hello world";
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return productService.saveProduct(productRequest);
    }
}
