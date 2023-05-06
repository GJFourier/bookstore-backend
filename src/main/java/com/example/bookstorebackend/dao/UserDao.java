package com.example.bookstorebackend.dao;

import com.example.bookstorebackend.entity.User;

public interface UserDao {
    User getByUserName(String username);
    User getById(Long id);
    void deleteById(Long id);
}
