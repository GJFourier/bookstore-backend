package com.example.bookstorebackend.dao.impl;

import com.example.bookstorebackend.dao.CartItemDao;
import com.example.bookstorebackend.entity.CartItem;
import com.example.bookstorebackend.repository.CartItemRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class CartItemDaoImpl implements CartItemDao {
    private final CartItemRepository cartItemRepository;

    public CartItemDaoImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public Optional<CartItem> findCartItemByUserIdAndBookId(Long userId, Long bookId) {
        return cartItemRepository.findCartItemByUserIdAndBookId(userId,bookId);
    }

    @Override
    public CartItem getCartItemByUserIdAndBookId(Long userId, Long bookId) {
        return cartItemRepository.getCartItemByUserIdAndBookId(userId, bookId);
    }

    @Override
    public void changeCountByUserIdAndBookId(Long userId, Long bookId, Long count) {
        CartItem cartItem = cartItemRepository.getCartItemByUserIdAndBookId(userId, bookId);
        cartItem.setCount(count);
        cartItemRepository.save(cartItem);
    }

    @Override
    public void addCountByUserIdAndBookId(Long userId, Long bookId) {
        CartItem cartItem = cartItemRepository.getCartItemByUserIdAndBookId(userId, bookId);
        changeCountByUserIdAndBookId(userId, bookId, cartItem.getCount() + 1);
    }

    @Override
    public List<CartItem> getCartItemByUserId(Long userId) {
        return cartItemRepository.getAllByUserId(userId);
    }

    @Override
    public void deleteCartItemByUserIdAndBookId(Long userId, Long bookId) {
        cartItemRepository.deleteCartItemByUserIdAndBookId(userId, bookId);
    }

    @Override
    public void save(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }


}
