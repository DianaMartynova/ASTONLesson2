package com.example.astonlesson2.mapper.Impl;

import com.example.astonlesson2.dto.AddressDto;
import com.example.astonlesson2.mapper.AddressMapper;
import com.example.astonlesson2.model.Address;

public class AddressMapperImpl implements AddressMapper {
    @Override
    public Address addressDtoToAddress(AddressDto addressDto) {
        if(addressDto !=null) {
            Address address = new Address();
            address.setId(addressDto.getIdDto());
            address.setCity(addressDto.getCityDto());
            address.setStreet(addressDto.getStreetDti());
            address.setHouseNumber(addressDto.getHouseNumberDto());
            return address;
        }
        return null;
    }

    @Override
    public AddressDto addressToAddressDto(Address address) {
        if(address !=null) {
            AddressDto addressDto = new AddressDto();
            addressDto.setIdDto(address.getId());
            addressDto.setCityDto(address.getCity());
            addressDto.setStreetDti(address.getStreet());
            addressDto.setHouseNumberDto(address.getHouseNumber());
            return addressDto;
        }
        return null;
    }
}
