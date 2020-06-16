package com.mama1emon.simplerestapi.services;

import com.mama1emon.simplerestapi.models.User;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUser(Long id);
    HttpStatus deleteUser(Long id);
}
