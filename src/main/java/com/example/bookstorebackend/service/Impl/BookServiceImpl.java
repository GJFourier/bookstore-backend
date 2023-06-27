package com.example.bookstorebackend.service.Impl;

import com.example.bookstorebackend.dao.BookDao;
import com.example.bookstorebackend.dao.OrderDao;
import com.example.bookstorebackend.entity.Book;
import com.example.bookstorebackend.entity.Order;
import com.example.bookstorebackend.entity.User;
import com.example.bookstorebackend.service.BookService;
import com.example.bookstorebackend.util.request.AddBookForm;
import com.example.bookstorebackend.util.request.BookAmountPrice;
import com.example.bookstorebackend.util.request.GerUserStatisticsForm;
import com.example.bookstorebackend.util.request.GetUserBookForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;
    private final OrderDao orderDao;

    public BookServiceImpl(BookDao bookDao, OrderDao orderDao) {
        this.bookDao = bookDao;
        this.orderDao = orderDao;
    }

    @Override
    public Book getBookById(Long id) {
        return bookDao.findBookById(id).orElseThrow();
    }

    @Override
    public Book getBookByAuthor(String author) {
        return bookDao.findBookByAuthor(author).orElseThrow();
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public void addBook(AddBookForm addBookForm) {
        bookDao.addBook(addBookForm);
    }

    @Override
    public void delBook(Long id) {
        bookDao.delBookById(id);
    }

    @Override
    public List<BookAmountPrice> getBookStatistics(Date beginTime, Date endTime) {
        List<BookAmountPrice> bookStatistics = new ArrayList<>();
        List<Order> orders = orderDao.getOrdersByTime(beginTime, endTime);
        orders.forEach(order -> {
            order.getOrderItemSet().forEach(orderItem -> {
                Book book = orderItem.getBook();
                Long amount = orderItem.getCount();
                Double price = orderItem.getBook().getPrice() * orderItem.getCount();

                boolean isExist = false;
                for (BookAmountPrice bookStatistic : bookStatistics) {
                    if (bookStatistic.getBook().equals(book)) {
                        bookStatistic.setAmount(bookStatistic.getAmount() + amount);
                        bookStatistic.setPrice(bookStatistic.getPrice() + price);
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    bookStatistics.add(new BookAmountPrice(book, amount, price));
                }

            });
        });
        return bookStatistics;
    }

    @Override
    public List<GerUserStatisticsForm> getUserStatistics(Date beginTime, Date endTime) {
        List<GerUserStatisticsForm> userStatistics = new ArrayList<>();
        List<Order> orders = orderDao.getOrdersByTime(beginTime, endTime);
        orders.forEach(order -> {
            User user = order.getUser();
            Double totalPrice = order.getPrice();
            boolean isExist = false;
            for (GerUserStatisticsForm userStatistic : userStatistics) {
                if (userStatistic.getUser().equals(user)) {
                    userStatistic.setTotalConsumption(userStatistic.getTotalConsumption() + totalPrice);
                    isExist = true;
                    break;
                }
            }
            if(!isExist){
                userStatistics.add(new GerUserStatisticsForm(user,totalPrice
                ));
            }
        });
        return userStatistics;
    }

    @Override
    public GetUserBookForm getUserBookForms(Date beginTime, Date endTime, Long userId) {
        GetUserBookForm userBookForms = new GetUserBookForm();
        userBookForms.setBookAmountPrices(new ArrayList<>());
        List<Order> orders = orderDao.getOrdersByTimeAndUserId(beginTime, endTime, userId);
        orders.forEach(order -> {
            Double totalPrice = order.getPrice();
            userBookForms.setTotalConsumption(userBookForms.getTotalConsumption() + totalPrice);

            order.getOrderItemSet().forEach(orderItem -> {
                Book book = orderItem.getBook();
                Long amount = orderItem.getCount();
                Double price = orderItem.getBook().getPrice() * orderItem.getCount();

                boolean isExist = false;
                for(BookAmountPrice bookAmountPrice: userBookForms.getBookAmountPrices()){
                    if(bookAmountPrice.getBook().equals(book)){
                        Long newAmount = bookAmountPrice.getAmount() + amount;
                        Double newPrice = bookAmountPrice.getPrice() + price;
                        userBookForms.getBookAmountPrices().remove(bookAmountPrice);
                        userBookForms.getBookAmountPrices().add(new BookAmountPrice(book,newAmount,newPrice));
                        isExist = true;
                        break;
                    }
                }
                if(!isExist){
                    userBookForms.getBookAmountPrices().add(new BookAmountPrice(book,amount,price));
                }
            });
        });

        return userBookForms;
    }

}

