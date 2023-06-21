package com.example.bookstorebackend.dao.impl;

import com.example.bookstorebackend.dao.BookDao;
import com.example.bookstorebackend.repository.BookRepository;
import com.example.bookstorebackend.entity.Book;
import com.example.bookstorebackend.util.request.AddBookForm;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDaoImpl implements BookDao{
    private final BookRepository bookRepository;
    public BookDaoImpl(BookRepository bookRepository){this.bookRepository = bookRepository;}

    @Override
    public Optional<Book> findBookById(Long id){
        return bookRepository.findById(id);
    }
    @Override
    public Optional<Book> findBookByAuthor(String author) {
        return bookRepository.findBookByAuthor(author);
    }

    @Override
    public Optional<Book> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public Book getBookByAuthor(String author) {
        return bookRepository.getBookByAuthor(author);
    }
    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.getByTitle(title);
    }
    @Override
    public List<Book> findAll(){
        return bookRepository.findAll();
    }
    @Override
    public void addBook(AddBookForm addBookForm) {
        Book book = bookRepository.getByTitle(addBookForm.getTitle());
        if(book == null)
            book = new Book();
        book.setAuthor(addBookForm.getAuthor());
        book.setDescription(addBookForm.getDescription());
        book.setIsbn(addBookForm.getIsbn());
        book.setInventory(addBookForm.getInventory());
        book.setImage(addBookForm.getImage());
        book.setPrice(addBookForm.getPrice());
        book.setPublisher(addBookForm.getPublisher());
        book.setTitle(addBookForm.getTitle());
        bookRepository.save(book);
    }
    @Override
    public void reduceCountById(Long id, Long count) {
        Book book = bookRepository.getBookById(id);
        book.setInventory(book.getInventory() - count);
        bookRepository.save(book);
    }
    @Override
    public void delBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
