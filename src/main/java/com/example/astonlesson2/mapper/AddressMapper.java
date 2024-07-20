package com.example.astonlesson2.mapper;

import com.example.astonlesson2.dto.AddressDto;
import com.example.astonlesson2.model.Address;

public interface AddressMapper {
    Address addressDtoToAddress(AddressDto addressDto);
    AddressDto addressToAddressDto(Address address);

}
