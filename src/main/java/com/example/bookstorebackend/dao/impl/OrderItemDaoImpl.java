package com.example.bookstorebackend.dao.impl;

import com.example.bookstorebackend.dao.OrderItemDao;
import com.example.bookstorebackend.entity.OrderItem;
import com.example.bookstorebackend.repository.OrderItemRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderItemDaoImpl implements OrderItemDao {
    private final OrderItemRepository orderItemRepository;
    public OrderItemDaoImpl(OrderItemRepository orderItemRepository){
        this.orderItemRepository = orderItemRepository;
    }
    @Override
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findAllByOrderId(orderId);
    }

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItemByOrderId(Long orderId) {
        orderItemRepository.deleteByOrderId(orderId);
    }
}
