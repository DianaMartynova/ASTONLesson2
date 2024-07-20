package com.example.astonlesson2.service;

import com.example.astonlesson2.dto.UserDto;


import java.util.List;


public interface ServiceUser {
    UserDto findById(int id);

    List<UserDto> getAll();

    void create(UserDto userDto);

    void update(UserDto userDto);

    void deleteById(int id);

}
