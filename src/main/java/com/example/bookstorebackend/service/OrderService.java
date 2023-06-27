package com.example.bookstorebackend.service;

import com.example.bookstorebackend.entity.Order;

import java.util.List;

public interface OrderService {
    boolean addOrder(Long userId);
    List<Order> getOrdersByUserId(Long userId);
    void deleteOrderById(Long orderId);
    List<Order> getAllOrder();
}
