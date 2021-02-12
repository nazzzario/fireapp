package com.store.mapper;

import com.store.dto.request.OrderRequest;
import com.store.dto.response.OrderResponse;
import com.store.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

//
//    @Mapping(target = "product", ignore = true)
//    @Mapping(target = "id", ignore = true)
//    Order requestToEntity(OrderRequest orderRequest);
//
//
//    @Mapping(target = "product", ignore = true)
//    @Mapping(target = "id", ignore = true)
//    Order requestToEntity(OrderRequest orderRequest, @MappingTarget Order order);
//
//    OrderResponse toDtoEntity(Order order);
}
