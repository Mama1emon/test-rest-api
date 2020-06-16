package com.mama1emon.simplerestapi.services;

import com.mama1emon.simplerestapi.dto.RoleDTO;
import com.mama1emon.simplerestapi.dto.UserDTO;
import com.mama1emon.simplerestapi.exceptions.IdNotFound;
import com.mama1emon.simplerestapi.models.User;
import com.mama1emon.simplerestapi.repository.RoleRepository;
import com.mama1emon.simplerestapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(IdNotFound::new);
    }

    @Override
    public HttpStatus deleteUser(Long id) {
        userRepository.deleteById(id);
        return HttpStatus.OK;
    }

    @Override
    public User editUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(IdNotFound::new);
        user.setName(userDTO.getName());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.getRoles().clear();
        for(RoleDTO roleDTO: userDTO.getRoles()){
            user.addUser(roleRepository.findById(roleDTO.getRoleId())
                    .orElseThrow(IdNotFound::new));
        }
        return userRepository.save(user);
    }

    @Override
    public User addUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());

        for(RoleDTO roleDTO: userDTO.getRoles()){
            user.addUser(roleRepository.findById(roleDTO.getRoleId())
                    .orElseThrow(IdNotFound::new));
        }
        return userRepository.save(user);
    }
}
