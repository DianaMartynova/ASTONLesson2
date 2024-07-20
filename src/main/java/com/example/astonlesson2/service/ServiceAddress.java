package com.example.astonlesson2.service;

import com.example.astonlesson2.dto.AddressDto;

import java.util.List;

public interface ServiceAddress {
    AddressDto findById(int id);

    List<AddressDto> getAll();

    void create(AddressDto addressDto);

    void update(AddressDto addressDto);

    void deleteById(int id);
}
