package com.example.bookstorebackend.service;

import com.example.bookstorebackend.entity.User;
import com.example.bookstorebackend.util.request.CheckUserForm;

public interface UserService {
    User checkUser(CheckUserForm checkUserForm);
    void deleteByUserId(Long userId);
}
