package com.example.bookstorebackend.controller;

import com.example.bookstorebackend.entity.Order;
import com.example.bookstorebackend.service.OrderService;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("api/order")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "add/{userId}")
    boolean addOrder(@PathVariable @NotNull Long userId){return orderService.addOrder(userId);}
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "get/{userId}", method = RequestMethod.GET)
    List<Order> getOrdersByUserId(@PathVariable @NotNull Long userId){return orderService.getOrdersByUserId(userId);}
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "delete/{orderId}", method = RequestMethod.DELETE)
    void deleteOrder(@PathVariable @NotNull Long orderId){orderService.deleteOrderById(orderId);}
}
