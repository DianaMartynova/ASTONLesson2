package com.example.astonlesson2.dto;

import com.example.astonlesson2.model.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@ToString
public class AddressDto {
    private int idDto;
    private String cityDto;
    private String streetDti;
    private String houseNumberDto;
    private List<AddressDto> listAddressDto;

}
