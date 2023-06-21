package com.example.bookstorebackend.dao;

import com.example.bookstorebackend.entity.User;
import com.example.bookstorebackend.util.request.ChangeUserProfileForm;

import java.util.List;

public interface UserDao {
    User getByUserName(String username);
    User getById(Long id);
    void deleteById(Long id);

    List<User> getAllCustomer();
    void changeStatus(Long userId, Integer status);
    boolean saveUser(String username, String password, String email);
    boolean saveProfileData(ChangeUserProfileForm changeUserProfileForm);
}
