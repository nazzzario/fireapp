package com.store.service.impl;

import com.store.dto.request.OrderRequest;
import com.store.dto.response.OrderResponse;
import com.store.mapper.OrderMapper;
import com.store.model.Order;
import com.store.model.Person;
import com.store.model.Product;
import com.store.repository.OrderRepository;
import com.store.repository.PersonRepository;
import com.store.repository.ProductRepository;
import com.store.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final PersonRepository personRepository;


    @Override
    public Order createOrder(Order order) {
        orderRepository.save(order);
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }
//    private final OrderMapper orderMapper;

//    @Override
//    public OrderResponse createOrder(OrderRequest orderRequest) {
//        Order order = orderMapper.requestToEntity(orderRequest);
//        Order save = orderRepository.save(order);
//        return orderMapper.toDtoEntity(save);
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public List<OrderResponse> getAllOrders() {
//        List<Order> all = orderRepository.findAll();
//        return all.stream().map(orderMapper::toDtoEntity).collect(Collectors.toList());
//    }
}
