package com.example.bookstorebackend.service.Impl;

import com.example.bookstorebackend.dao.UserDao;
import com.example.bookstorebackend.entity.User;
import com.example.bookstorebackend.service.UserService;
import com.example.bookstorebackend.util.request.CheckUserForm;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User checkUser(CheckUserForm checkUserForm) {
        User user = userDao.getByUserName(checkUserForm.getUsername());
        if (Objects.equals(checkUserForm.getPassword(), user.getUserAuth().getPassword()))
            return user;
        else
            return null;
    }

    @Override
    public void deleteByUserId(Long userId) {
        userDao.deleteById(userId);
    }
}
