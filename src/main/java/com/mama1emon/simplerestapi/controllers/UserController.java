package com.mama1emon.simplerestapi.controllers;

import com.mama1emon.simplerestapi.dto.UserDTO;
import com.mama1emon.simplerestapi.mappers.UserMapper;
import com.mama1emon.simplerestapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    private final UserMapper userMapper;

    @GetMapping("/list")
    public @ResponseBody Iterable<UserDTO> getAllUsers(){
        return userMapper.toListUserDTO(userService.getAllUsers());
    }

    @GetMapping("/get/{id}")
    public UserDTO getUserById(@PathVariable(name = "id") Long userId){
        return userMapper.toUserDTO(userService.getUser(userId));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteUserById(@PathVariable(name = "id") Long id){
        return userService.deleteUser(id);
    }
}
