package com.example.bookstorebackend.repository;

import com.example.bookstorebackend.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findCartItemByUserIdAndBookId(Long userId, Long bookId);
    CartItem getCartItemByUserIdAndBookId(Long userId, Long bookId);
    void deleteCartItemByUserIdAndBookId(Long userId, Long bookId);
    List<CartItem> getAllByUserId(Long userId);
}
