package com.example.bookstorebackend.controller;
import com.example.bookstorebackend.entity.Book;
import com.example.bookstorebackend.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){this.bookService = bookService;}
    @RequestMapping(value = "api/book/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    Book getBookById(@PathVariable Long id){return bookService.getBookById(id);}

    @RequestMapping(value = "api/book/author/{author}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    Book getBookByAuthor(@PathVariable String author){return bookService.getBookByAuthor(author);}

    @RequestMapping(value = "api/book/all", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    List<Book> findAll(){
        return bookService.findAll();
    }
}
