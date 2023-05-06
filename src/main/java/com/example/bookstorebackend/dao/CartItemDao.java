package com.example.bookstorebackend.dao;

import com.example.bookstorebackend.entity.CartItem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CartItemDao {
    Optional<CartItem> findCartItemByUserIdAndBookId(Long userId, Long BookId);
    CartItem getCartItemByUserIdAndBookId(Long userId, Long bookId);
    void changeCountByUserIdAndBookId(Long userId, Long bookId, Long count);
    void addCountByUserIdAndBookId(Long userId, Long bookId);
    List<CartItem> getCartItemByUserId(Long userId);
    void deleteCartItemByUserIdAndBookId(Long userId, Long bookId);
    void save(CartItem cartItem);
}
