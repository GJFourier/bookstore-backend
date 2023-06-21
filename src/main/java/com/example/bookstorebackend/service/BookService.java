package com.example.bookstorebackend.service;
import com.example.bookstorebackend.entity.Book;
import com.example.bookstorebackend.util.request.AddBookForm;

import java.util.List;

public interface BookService {
    Book getBookById(Long id);
    Book getBookByAuthor(String author);
    List<Book> findAll();

    void addBook(AddBookForm addBookForm);

    void delBook(Long id);
}
