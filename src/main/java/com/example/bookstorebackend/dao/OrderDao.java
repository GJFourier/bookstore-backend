package com.example.bookstorebackend.dao;

import com.example.bookstorebackend.entity.Order;

import java.util.List;

public interface OrderDao {
    void saveOrder(Order order);
    List<Order> getOrdersByUserId(Long userId);
    void deleteOrderByOrderId(Long orderId);

}
