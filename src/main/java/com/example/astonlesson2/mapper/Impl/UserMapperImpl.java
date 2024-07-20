package com.example.astonlesson2.mapper.Impl;

import com.example.astonlesson2.dto.UserDto;
import com.example.astonlesson2.mapper.UserMapper;
import com.example.astonlesson2.model.User;

public class UserMapperImpl implements UserMapper {


    @Override
    public UserDto userToUserDto(User user) {
        if (user !=null){
            UserDto userDto = new UserDto();
            userDto.setIdDto(user.getId());
            userDto.setNameFIODto(user.getNameFIO());
            userDto.setUsersAddressesDto(user.getUsersAddresses());
            return userDto;
        }
        return null;
    }

    @Override
    public User userDtoToUser(UserDto userDto) {
        if (userDto !=null){
            User user = new User();
            user.setId(userDto.getIdDto());
            user.setNameFIO(userDto.getNameFIODto());
            user.setUsersAddresses(userDto.getUsersAddressesDto());

            return user;
        }
        return null;
    }
}
