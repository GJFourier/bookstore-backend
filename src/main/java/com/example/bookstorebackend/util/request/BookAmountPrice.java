package com.example.bookstorebackend.util.request;

import com.example.bookstorebackend.entity.Book;

public class BookAmountPrice{
    Book book;
    Long amount;
    Double price;
    public BookAmountPrice(Book book,Long amount,Double price){
        this.book = book;
        this.amount = amount;
        this.price = price;
    }
    public Book getBook(){
        return book;
    }
    public Long getAmount(){
        return amount;
    }
    public Double getPrice(){
        return price;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public void setBook(Book book){
        this.book = book;
    }
}