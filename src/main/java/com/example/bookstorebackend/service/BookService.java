package com.example.bookstorebackend.service;
import com.example.bookstorebackend.entity.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Long id);
    Book getBookByAuthor(String author);
    List<Book> findAll();
}
