package com.example.bookstorebackend.service.Impl;

import com.example.bookstorebackend.dao.BookDao;
import com.example.bookstorebackend.entity.Book;
import com.example.bookstorebackend.service.BookService;
import com.example.bookstorebackend.util.request.AddBookForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;
    public BookServiceImpl(BookDao bookDao){
        this.bookDao = bookDao;
    }
    @Override
    public Book getBookById(Long id){
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
}
