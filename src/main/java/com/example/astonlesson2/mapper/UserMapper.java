package com.example.astonlesson2.mapper;

import com.example.astonlesson2.dto.UserDto;
import com.example.astonlesson2.model.User;

public interface UserMapper {
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
