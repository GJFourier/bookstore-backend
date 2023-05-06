package com.example.bookstorebackend.controller;

import com.example.bookstorebackend.entity.User;
import com.example.bookstorebackend.service.UserService;
import com.example.bookstorebackend.util.request.CheckUserForm;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value = "api/user/checkUser", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public User checkUser(@RequestBody @NotNull CheckUserForm checkUserForm){
        return userService.checkUser(checkUserForm);
    }
}
