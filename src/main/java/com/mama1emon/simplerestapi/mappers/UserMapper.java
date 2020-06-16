package com.mama1emon.simplerestapi.mappers;

import com.mama1emon.simplerestapi.dto.UserDTO;
import com.mama1emon.simplerestapi.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserDTO toUserDTO(User user);
    List<UserDTO> toListUserDTO(List<User> users);
}
