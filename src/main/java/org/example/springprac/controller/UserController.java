package org.example.springprac.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springprac.model.User;
import org.example.springprac.request.UserRequest;
import org.example.springprac.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public User addUser(@RequestBody UserRequest user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody @Valid UserRequest user){
        User foundedUser = userService.getUser(user.getUsername());
        if (foundedUser == null) return null;
        if (!foundedUser.getPassword().equals(user.getPassword())) return null;
        return foundedUser;
    }
}
