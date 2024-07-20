package com.example.astonlesson2.service.impl;

import com.example.astonlesson2.dto.UserDto;
import com.example.astonlesson2.mapper.UserMapper;
import com.example.astonlesson2.model.User;

import com.example.astonlesson2.repository.RepositoryUser;
import com.example.astonlesson2.service.ServiceUser;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
public class ServiceUserImpl implements ServiceUser {
   private RepositoryUser repository;
   private UserMapper userMapper;
    @Override
    public UserDto findById(int id) {
        return userMapper.userToUserDto(repository.findById(id));
    }

    @Override
    public List<UserDto> getAll() {
        return repository.getAll().stream().map(userMapper::userToUserDto).collect(Collectors.toList());
    }



    @Override
    public void create(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        repository.create(user);

    }

    @Override
    public void update( UserDto userDto) {
       int idNow = userDto.getIdDto();
       User user = repository.findById(idNow);
       user.setNameFIO(userDto.getNameFIODto());

    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);

    }
}
