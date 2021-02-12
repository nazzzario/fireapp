package com.store.service;

import com.store.dto.request.OrderRequest;
import com.store.dto.response.OrderResponse;
import com.store.model.Order;

import java.util.List;

public interface OrderService {
//    OrderResponse createOrder(OrderRequest orderRequest);
//
//    List<OrderResponse> getAllOrders();
//
    Order createOrder(Order orderRequest);

    List<Order> getAllOrders();
}
