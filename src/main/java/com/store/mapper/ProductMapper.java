package com.store.mapper;

import com.store.dto.request.ProductRequest;
import com.store.dto.response.ProductResponse;
import com.store.model.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    Product requestToEntity(ProductRequest dto);


    @Mapping(target = "photoLink", ignore = true)
    @Mapping(target = "id", ignore = true)
    Product requestToEntity(ProductRequest dto, @MappingTarget Product product);


    @Mapping(target = "photoLink", ignore = true)
    ProductResponse toDtoResponse(Product entity);
}
