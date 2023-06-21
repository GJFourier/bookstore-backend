package com.example.bookstorebackend.dao.impl;

import com.example.bookstorebackend.dao.UserDao;
import com.example.bookstorebackend.entity.User;
import com.example.bookstorebackend.entity.UserAuth;
import com.example.bookstorebackend.repository.UserAuthRepository;
import com.example.bookstorebackend.repository.UserRepository;
import com.example.bookstorebackend.util.request.ChangeUserProfileForm;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class UserDaoImpl implements UserDao {
    private final UserRepository userRepository;
    private final UserAuthRepository userAuthRepository;

    public UserDaoImpl(UserRepository userRepository, UserAuthRepository userAuthRepository) {
        this.userRepository = userRepository;
        this.userAuthRepository = userAuthRepository;
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

    @Override
    public List<User> getAllCustomer() {
        return userRepository.getAllByRole(0);
    }

    @Override
    public void changeStatus(Long userId, Integer status){
        User user = userRepository.getUserById(userId);
        user.setStatus(status);
        userRepository.save(user);
    }

    @Override
    public boolean saveUser(String username, String password, String email) {
        if(userRepository.findByUsername(username).isEmpty()){
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            UserAuth userAuth = new UserAuth();
            userAuth.setUsername(username);
            userAuth.setPassword(password);
            userAuth.setUser(user);
            user.setUserAuth(userAuth);
            user.setRole(0);
            user.setStatus(1);
            user.setAvatar("个人头像.jpg");
            userRepository.save(user);
            userAuthRepository.save(userAuth);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean saveProfileData(ChangeUserProfileForm changeUserProfileForm) {
        User user = userRepository.getUserById(changeUserProfileForm.getId());
        user.setUsername(changeUserProfileForm.getUsername());
        user.setEmail(changeUserProfileForm.getEmail());
        user.setSignature(changeUserProfileForm.getSignature());
        userRepository.save(user);
        return true;
    }

}
