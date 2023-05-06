package com.example.bookstorebackend.dao.impl;

import com.example.bookstorebackend.dao.UserDao;
import com.example.bookstorebackend.entity.User;
import com.example.bookstorebackend.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    private final UserRepository userRepository;

    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getByUserName(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
