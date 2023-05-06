package com.example.bookstorebackend.dao;
import com.example.bookstorebackend.entity.OrderItem;
import com.example.bookstorebackend.repository.OrderItemRepository;

import java.util.List;

public interface OrderItemDao {
    List<OrderItem> getOrderItemsByOrderId(Long orderId);
    void saveOrderItem(OrderItem orderItem);
    void deleteOrderItemByOrderId(Long orderId);
}
