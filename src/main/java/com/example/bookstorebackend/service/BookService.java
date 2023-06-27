package com.example.bookstorebackend.service;
import com.example.bookstorebackend.entity.Book;
import com.example.bookstorebackend.util.request.AddBookForm;
import com.example.bookstorebackend.util.request.BookAmountPrice;
import com.example.bookstorebackend.util.request.GerUserStatisticsForm;
import com.example.bookstorebackend.util.request.GetUserBookForm;

import java.util.Date;
import java.util.List;

public interface BookService {
    Book getBookById(Long id);
    Book getBookByAuthor(String author);
    List<Book> findAll();

    void addBook(AddBookForm addBookForm);

    void delBook(Long id);

    List<BookAmountPrice> getBookStatistics(Date beginTime, Date endTime);
    List<GerUserStatisticsForm> getUserStatistics(Date beginTime, Date endTime);
    GetUserBookForm getUserBookForms(Date beginTime, Date endTime, Long userId);
}
