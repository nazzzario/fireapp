package com.store.controller;

import com.store.dto.request.OrderRequest;
import com.store.dto.response.OrderResponse;
import com.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

//    @PostMapping("/create")
//    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest){
//        return orderService.createOrder(orderRequest);
//    }
//
//    @GetMapping("/all")
//    public List<OrderResponse> getAllOrders(){
//        return orderService.getAllOrders();
//    }


}
