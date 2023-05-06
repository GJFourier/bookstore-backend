package com.example.bookstorebackend.repository;

import com.example.bookstorebackend.entity.Order;
import com.example.bookstorebackend.entity.OrderItem;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    void deleteByOrderId(Long orderId);
    List<OrderItem> findAllByOrderId(Long orderId);
}
