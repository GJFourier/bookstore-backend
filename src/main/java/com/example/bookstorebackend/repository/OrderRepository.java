package com.example.bookstorebackend.repository;

import com.example.bookstorebackend.entity.Order;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findOrderById(Long id);
    void deleteById(@NotNull Long id);
    List<Order> getAllByUserId(Long userid);
}
