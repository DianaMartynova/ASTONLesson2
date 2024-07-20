package com.example.astonlesson2.dto;

import com.example.astonlesson2.model.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class UserDto {
    private int idDto;
    private String nameFIODto;
    private List<Address> usersAddressesDto;
}
