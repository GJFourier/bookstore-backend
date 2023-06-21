package com.example.bookstorebackend.service;

import com.example.bookstorebackend.entity.User;
import com.example.bookstorebackend.util.request.ChangeUserProfileForm;
import com.example.bookstorebackend.util.request.CheckUserForm;

import java.util.List;

public interface UserService {
    User checkUser(CheckUserForm checkUserForm);
    void deleteByUserId(Long userId);

    List<User> getAllCustomer();
    void changeStatus(Long userId, Integer status);

    boolean register(String username, String password, String email);

    boolean saveProfileData(ChangeUserProfileForm changeUserProfileForm);
}
