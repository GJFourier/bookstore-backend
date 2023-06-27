package com.example.bookstorebackend.util.request;

import org.springframework.data.util.Pair;
import com.example.bookstorebackend.entity.Book;
import com.example.bookstorebackend.entity.User;

import java.util.List;

public class GerUserStatisticsForm {
    private User user;
    private Double totalConsumption;
//    private List<BookAmountPrice> bookAmountPrices;

    public GerUserStatisticsForm(User user, Double totalPrice
//            , List<BookAmountPrice> bookAmountPrices
    ) {
        this.user = user;
        this.totalConsumption = totalPrice;
//        this.bookAmountPrices = bookAmountPrices;
    }

    public User getUser(){
        return user;
    }
    public double getTotalConsumption(){
        return totalConsumption;
    }

//    public List<BookAmountPrice> getBookAmountPrices() {
//        return bookAmountPrices;
//    }

    public void setUser(User user){
        this.user = user;
    }
    public void setTotalConsumption(Double totalConsumption){
        this.totalConsumption = totalConsumption;
    }

//    public void setBookAmountPrices(List<BookAmountPrice> bookAmountPrices) {
//        this.bookAmountPrices = bookAmountPrices;
//    }
}
