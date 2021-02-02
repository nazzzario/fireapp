package com.store.service;

import com.store.dto.request.ProductRequest;
import com.store.dto.response.ProductResponse;
import com.store.mapper.ProductMapper;
import com.store.model.Product;
import com.store.repository.ProductRepository;
import com.store.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvcExtensionsKt;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;
    private Product productNext;
    private ProductResponse productResponse;
    private ProductRequest productRequest;
    private ProductResponse productResponseNext;
    private ProductRequest productRequestNext;

    @BeforeEach
    public void setUp(){
        product = new Product(
                1L,
                "Fire alarm",
                100,
                200,
                "https://images-na.ssl-images-amazon.com/images/I/71QIJ-faz2L._AC_SL1500_.jpg"

        );

        productNext = new Product(
                2L,
                "Pro Fire alarm",
                1000,
                50,
                "https://images-na.ssl-images-amazon.com/images/I/71QIJ-faz2L._AC_SL1500_.jpg"

        );

        productResponse = new ProductResponse(
                "Fire alarm",
                100,
                "https://images-na.ssl-images-amazon.com/images/I/71QIJ-faz2L._AC_SL1500_.jpg"
        );
        productResponseNext = new ProductResponse(
                "Pro Fire alarm",
                1000,
                "https://images-na.ssl-images-amazon.com/images/I/71QIJ-faz2L._AC_SL1500_.jpg"
        );

        productRequest = new ProductRequest(
                "Fire alarm",
                100,
                200,
                "https://images-na.ssl-images-amazon.com/images/I/71QIJ-faz2L._AC_SL1500_.jpg"
        );
        productRequestNext = new ProductRequest(
                "Pro Fire alarm",
                1000,
                50,
                "https://images-na.ssl-images-amazon.com/images/I/71QIJ-faz2L._AC_SL1500_.jpg"
        );
    }

    @Order(1)
    @Test
    void shouldCreateValidProduct(){
        Mockito.when(productMapper.requestToEntity(productRequest)).thenReturn(product);
        Mockito.when(productRepository.save(product)).thenReturn(product);
        Mockito.when(productMapper.toDtoResponse(product)).thenReturn(productResponse);

        ProductResponse testProduct = productService.saveProduct(productRequest);

        Mockito.verify(productMapper).requestToEntity(productRequest);
        Mockito.verify(productRepository).save(product);

        assertThat(testProduct).isEqualTo(productResponse);

    }

    @Order(2)
    @Test
    void shouldFindProductById(){
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Mockito.when(productMapper.toDtoResponse(product)).thenReturn(productResponse);

        ProductResponse testProduct = productService.getProductById(1L);

        assertThat(productResponse).isEqualTo(testProduct);

    }

    @Order(3)
    @Test
    void shouldReturnListOfProduct(){
        Mockito.when(productRepository.findAll()).thenReturn(List.of(product,productNext));
        Mockito.when(productMapper.toDtoResponse(product)).thenReturn(productResponse);
        Mockito.when(productMapper.toDtoResponse(productNext)).thenReturn(productResponseNext);

        List<ProductResponse> allProducts = productService.getAllProducts();

        assertThat(allProducts).isNotEmpty();
        assertThat(allProducts.size()).isEqualTo(List.of(productResponse, productResponseNext).size());

    }

    @Order(4)
    @Test
    void shouldThrowExceptionWhenProductIsNull(){
        Mockito.when(productMapper.requestToEntity(productRequest)).thenReturn(product);
        Mockito.when(productRepository.save(product)).thenReturn(null);
        assertThrows(NullPointerException.class, () -> productService.saveProduct(null));

    }

    @Order(5)
    @Test
    void shouldUpdateProduct(){
        Mockito.when(productRepository.findById(1L))
                .thenReturn(java.util.Optional.ofNullable(product));
        Mockito.when(productMapper.requestToEntity(productRequest, product))
                .thenReturn(product);
        Mockito.when(productRepository.save(product))
                .thenReturn(product);
        Mockito.when(productMapper.toDtoResponse(product))
                .thenReturn(productResponse);


        ProductResponse testUpdate = productService.update(1L, productRequest);
        assertThat(testUpdate).isNotEqualTo(productResponseNext).isNotNull();


    }

    @Order(6)
    @Test
    void shouldThrowExceptionWheUpdateProduct(){
        Mockito.when(productRepository.findById(1L))
                .thenReturn(java.util.Optional.ofNullable(product));
        Mockito.when(productMapper.requestToEntity(productRequest, product))
                .thenReturn(product);
        Mockito.when(productRepository.save(product))
                .thenReturn(product);
        Mockito.when(productMapper.toDtoResponse(product))
                .thenReturn(productResponse);

        assertThrows(NullPointerException.class, () -> productService.update(8L, productRequest));

    }

    @Order(7)
    @Test
    void shouldDeleteProduct(){
        Mockito.when(productRepository.findById(1L))
                .thenReturn(java.util.Optional.ofNullable(product));
        doNothing()
                .when(productRepository)
                .deleteById(1L);

        productService.deleteProductById(1L);

        Mockito.verify(productRepository)
                .findById(1L);
        Mockito.verify(productRepository)
                .deleteById(1L);
    }

    @Order(8)
    @Test
    void shouldThrowExceptionWithException(){
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(product));
        doNothing()
                .when(productRepository)
                .deleteById(1L);

        productService.deleteProductById(1L);

        Mockito.verify(productRepository)
                .findById(1L);
        Mockito.verify(productRepository)
                .deleteById(1L);


        assertThrows(NullPointerException.class, () -> productService.deleteProductById(8L));

    }

}
