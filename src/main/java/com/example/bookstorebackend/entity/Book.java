package com.example.bookstorebackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "author")
    private String author;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "price")
    private Double price;
    @Column(name = "description", length = 128)
    private String description;
    @Column(name = "inventory")
    private Long inventory;
    public Book(String title, String image, String author, String isbn, String publisher, double price,  String description){
        this.title = title;
        this.image = image;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.price = price;
        this.publisher = publisher;
    }
    public Book(){}
}
