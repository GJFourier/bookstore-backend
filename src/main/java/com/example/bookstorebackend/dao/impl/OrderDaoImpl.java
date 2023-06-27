package com.example.bookstorebackend.dao.impl;

import com.example.bookstorebackend.dao.OrderDao;
import com.example.bookstorebackend.entity.Order;
import com.example.bookstorebackend.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
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

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByTime(Date beginTime, Date endTime) {
        return orderRepository.getOrdersByTimeBetween(beginTime,endTime);
    }

    @Override
    public List<Order> getOrdersByTimeAndUserId(Date beginTime, Date endTime, Long userId) {
        return orderRepository.getOrdersByTimeBetweenAndUserId(beginTime, endTime, userId);
    }
}
