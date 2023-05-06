package com.example.bookstorebackend.dao.impl;

import com.example.bookstorebackend.dao.UserAuthDao;
import com.example.bookstorebackend.entity.UserAuth;
import com.example.bookstorebackend.repository.UserAuthRepository;
import org.springframework.stereotype.Component;

@Component
public class UserAuthDaoImpl implements UserAuthDao {
    private final UserAuthRepository userAuthRepository;

    public UserAuthDaoImpl(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    @Override
    public UserAuth getByUserId(Long userId) {
        return userAuthRepository.getByUserId(userId);
    }

    @Override
    public void deleteByUserId(Long userId) {
        userAuthRepository.deleteByUserId(userId);
    }

    @Override
    public UserAuth getByUsername(String username) {
        return userAuthRepository.getByUsername(username);
    }
}
