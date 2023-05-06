package com.example.bookstorebackend.dao.impl;

import com.example.bookstorebackend.dao.OrderDao;
import com.example.bookstorebackend.entity.Order;
import com.example.bookstorebackend.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDaoImpl implements OrderDao {
    private final OrderRepository orderRepository;

    public OrderDaoImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
         return orderRepository.getAllByUserId(userId);
    }

    @Override
    public void deleteOrderByOrderId(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
