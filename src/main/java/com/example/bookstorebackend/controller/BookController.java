package com.example.bookstorebackend.controller;
import com.example.bookstorebackend.entity.Book;
import com.example.bookstorebackend.service.BookService;
import com.example.bookstorebackend.util.request.*;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "api/book/add", method = RequestMethod.PUT)
    void changeCountByUserIdAndBookId(@RequestBody @NotNull AddBookForm addBookForm){
        bookService.addBook(addBookForm);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "api/book/del", method = RequestMethod.DELETE)
    void changeCountByUserIdAndBookId(@PathParam("id") Long id){
        bookService.delBook(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "api/book/get/statistics/byBook",method = RequestMethod.GET)
    List<BookAmountPrice> getBookStatisticsByBook(
            @PathParam("beginTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date beginTime,
            @PathParam("endTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endTime){
        return bookService.getBookStatistics(beginTime,endTime);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "api/book/get/statistics/byUser",method = RequestMethod.GET)
    List<GerUserStatisticsForm> getBookStatisticsByUser(
            @PathParam("beginTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date beginTime,
            @PathParam("endTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endTime){
        return bookService.getUserStatistics(beginTime,endTime);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "api/book/get/statistics/{userId}",method = RequestMethod.GET)
    GetUserBookForm getUserBookForms(
            @PathParam("beginTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date beginTime,
            @PathParam("endTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endTime,
            @PathVariable Long userId){
        return bookService.getUserBookForms(beginTime,endTime,userId);
    }
}
