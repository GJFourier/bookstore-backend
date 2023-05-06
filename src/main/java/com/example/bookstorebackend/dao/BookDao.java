package com.example.bookstorebackend.dao;

import com.example.bookstorebackend.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    Optional<Book> findBookById(Long id);
    Optional<Book> findBookByAuthor(String author);
    Optional<Book> findBookByTitle(String title);
    Book getBookById(Long id);
    Book getBookByAuthor(String author);
    Book getBookByTitle(String title);
    List<Book> findAll();
}
