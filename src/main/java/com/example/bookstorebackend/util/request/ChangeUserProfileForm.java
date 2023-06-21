package com.example.bookstorebackend.util.request;

public class ChangeUserProfileForm {
    private Long id;
    private String username;
    private String email;
    private String signature;
    public Long getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getSignature(){
        return signature;
    }
}
