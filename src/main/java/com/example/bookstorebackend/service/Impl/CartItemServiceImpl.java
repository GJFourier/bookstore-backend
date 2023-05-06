package com.example.bookstorebackend.service.Impl;

import com.example.bookstorebackend.dao.BookDao;
import com.example.bookstorebackend.dao.CartItemDao;
import com.example.bookstorebackend.dao.UserDao;
import com.example.bookstorebackend.entity.Book;
import com.example.bookstorebackend.entity.CartItem;
import com.example.bookstorebackend.entity.User;
import com.example.bookstorebackend.service.CartItemService;
import com.example.bookstorebackend.util.request.ChangeCartItemForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemDao cartItemDao;
    private final BookDao bookDao;
    private final UserDao userDao;

    public CartItemServiceImpl(CartItemDao cartItemDao, BookDao bookDao, UserDao userDao) {
        this.cartItemDao = cartItemDao;
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    @Override
    public boolean addCartItem(ChangeCartItemForm changeCartItemForm) {
        Long bookId = changeCartItemForm.getBookId();
        Long userId = changeCartItemForm.getUserId();
        Long count = changeCartItemForm.getCount();
        if(cartItemDao.findCartItemByUserIdAndBookId(userId, bookId).isPresent()){
            // 已加入到购物车中
            System.out.println("已加入购物车中，请勿重复点击");
            return false;
        }
        else {
            Book book = bookDao.getBookById(bookId);
            User user = userDao.getById(userId);
            if(book == null){
                System.out.println("没有找到该书本");
                return false;
            }
            else {
                cartItemDao.save(new CartItem(book, user, count));
                return true;
            }
        }
    }

    @Override
    public void changeCountByUserIdAndBookId(ChangeCartItemForm changeCartItemForm) {
        Optional<CartItem> optionalCartItem = cartItemDao.findCartItemByUserIdAndBookId(changeCartItemForm.getUserId(),changeCartItemForm.getBookId());
        if(optionalCartItem.isPresent()){
            CartItem cartItem = optionalCartItem.get();
            cartItem.setCount(changeCartItemForm.getCount());
            cartItemDao.save(cartItem);
        }else {
            System.out.println("Error");
        }
    }

    @Override
    public List<CartItem> getCartItemByUserId(Long userId) {
        return cartItemDao.getCartItemByUserId(userId);
    }

    @Override
    public void deleteCartItemByUserIdAndBookId(Long userId, Long bookId) {
        cartItemDao.deleteCartItemByUserIdAndBookId(userId, bookId);
    }
}
