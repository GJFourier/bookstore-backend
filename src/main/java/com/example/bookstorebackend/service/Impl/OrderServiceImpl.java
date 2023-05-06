package com.example.bookstorebackend.service.Impl;

import com.example.bookstorebackend.dao.*;
import com.example.bookstorebackend.entity.*;
import com.example.bookstorebackend.service.OrderService;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final UserDao userDao;
    private final OrderItemDao orderItemDao;
    private final CartItemDao cartItemDao;

    public OrderServiceImpl(OrderDao orderDao, UserDao userDao, BookDao bookDao, OrderItemDao orderItemDao, CartItemDao cartItemDao) {
        this.orderDao = orderDao;
        this.userDao = userDao;
        this.orderItemDao = orderItemDao;
        this.cartItemDao = cartItemDao;
    }

    @Override
    public boolean addOrder(Long userId) {
        User user = userDao.getById(userId);
        List<CartItem> cart = cartItemDao.getCartItemByUserId(userId);
        double totalPrice = 0.0;

        Date date = new Date();
        for (CartItem cartItem:cart){
            totalPrice += cartItem.getCount() * cartItem.getBook().getPrice();
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
}
