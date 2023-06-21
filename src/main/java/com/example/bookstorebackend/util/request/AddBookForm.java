package com.example.bookstorebackend.util.request;

public class AddBookForm {
    private String title;
    private String image;
    private String author;
    private String isbn;
    private String publisher;
    private double price;
    private String description;
    private Long inventory;
    public String getTitle(){
        return title;
    }
    public String getImage(){
        return image;
    }
    public String getAuthor(){
        return author;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getPublisher(){
        return publisher;
    }
    public double getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }
    public Long getInventory(){
        return inventory;
    }
}
