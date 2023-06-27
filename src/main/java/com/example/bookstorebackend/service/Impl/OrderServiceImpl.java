package com.example.bookstorebackend.service.Impl;

import com.example.bookstorebackend.dao.*;
import com.example.bookstorebackend.entity.*;
import com.example.bookstorebackend.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final UserDao userDao;
    private final OrderItemDao orderItemDao;
    private final CartItemDao cartItemDao;
    private final BookDao bookDao;
    public OrderServiceImpl(OrderDao orderDao, UserDao userDao, OrderItemDao orderItemDao, CartItemDao cartItemDao, BookDao bookDao1, BookDao bookDao) {
        this.orderDao = orderDao;
        this.userDao = userDao;
        this.orderItemDao = orderItemDao;
        this.cartItemDao = cartItemDao;
        this.bookDao = bookDao;
    }

    @Override
    public boolean addOrder(Long userId) {
        User user = userDao.getById(userId);
        List<CartItem> cart = cartItemDao.getCartItemByUserId(userId);
        double totalPrice = 0.0;

        Date date = new Date();
        for (CartItem cartItem:cart){
            totalPrice += cartItem.getCount() * cartItem.getBook().getPrice();
            Book book = cartItem.getBook();
            bookDao.reduceCountById(book.getId(), cartItem.getCount());
        }
        Order order = new Order(totalPrice, date, user);
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem:cart){
            Book book = cartItem.getBook();
            OrderItem orderItem = new OrderItem(cartItem.getCount(), book, order);
            orderItems.add(orderItem);
            cartItemDao.deleteCartItemByUserIdAndBookId(userId, book.getId());
        }
        orderDao.saveOrder(order);
        System.out.println(orderItems.size());
        for(OrderItem orderItem:orderItems){
            orderItemDao.saveOrderItem(orderItem);
        }
        return true;
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return orderDao.getOrdersByUserId(userId);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderDao.deleteOrderByOrderId(orderId);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderDao.getAllOrder();
    }
}
