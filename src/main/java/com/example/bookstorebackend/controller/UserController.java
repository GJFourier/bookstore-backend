package com.example.bookstorebackend.controller;

import com.example.bookstorebackend.entity.User;
import com.example.bookstorebackend.service.UserService;
import com.example.bookstorebackend.util.request.ChangeUserProfileForm;
import com.example.bookstorebackend.util.request.CheckUserForm;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value = "api/user/checkUser", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public User checkUser(@RequestBody @NotNull CheckUserForm checkUserForm){
        return userService.checkUser(checkUserForm);
    }

    @RequestMapping(value = "api/user/getAll", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public List<User> getAllCustomer(){
        return userService.getAllCustomer();
    }

    @RequestMapping(value = "api/user/changeStatus", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public void changeStatus(@PathParam("userId") Long userId, @PathParam("status") Integer status){
        userService.changeStatus(userId, status);
    }
    @RequestMapping(value = "api/user/register", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public boolean register(@PathParam("username") String username, @PathParam("password") String password, @PathParam("email") String email){
        return userService.register(username, password, email);
    }
    @RequestMapping(value = "api/user/saveProfileData", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public boolean saveProfileData(@RequestBody ChangeUserProfileForm changeUserProfileForm){
        return userService.saveProfileData(changeUserProfileForm);
    }
}
