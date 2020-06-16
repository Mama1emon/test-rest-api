package com.mama1emon.simplerestapi.controllers;

import com.mama1emon.simplerestapi.models.User;
import com.mama1emon.simplerestapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/list")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}
