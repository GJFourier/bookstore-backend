package com.example.bookstorebackend.service;

import com.example.bookstorebackend.entity.CartItem;
import com.example.bookstorebackend.util.request.ChangeCartItemForm;

import java.util.List;
import java.util.Set;

public interface CartItemService {
    boolean addCartItem(ChangeCartItemForm changeCartItemForm);
    void changeCountByUserIdAndBookId(ChangeCartItemForm changeCartItemForm);
    List<CartItem> getCartItemByUserId(Long userId);
    void deleteCartItemByUserIdAndBookId(Long userId, Long bookId);
}
