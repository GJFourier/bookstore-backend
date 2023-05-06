package com.example.bookstorebackend.util.request;

public class ChangeCartItemForm {
    private Long userId;
    private Long bookId;
    private Long count;

    public Long getBookId(){
        return bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCount() {
        return count;
    }
}
