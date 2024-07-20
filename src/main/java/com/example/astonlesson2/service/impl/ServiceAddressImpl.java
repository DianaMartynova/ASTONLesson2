package com.example.astonlesson2.service.impl;

import com.example.astonlesson2.dto.AddressDto;
import com.example.astonlesson2.mapper.AddressMapper;
import com.example.astonlesson2.model.Address;
import com.example.astonlesson2.repository.RepositoryAddress;

import com.example.astonlesson2.service.ServiceAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServiceAddressImpl implements ServiceAddress {
    private RepositoryAddress repository;
    private AddressMapper addressMapper;
    @Override
    public AddressDto findById(int id) {
        return addressMapper.addressToAddressDto(repository.findById(id));
    }

    @Override
    public List<AddressDto> getAll() {
        return repository.getAll().stream().map(addressMapper::addressToAddressDto).collect(Collectors.toList());
    }

    @Override
    public void create(AddressDto addressDto) {
        Address address = addressMapper.addressDtoToAddress(addressDto);
        repository.create(address);


    }

    @Override
    public void update(AddressDto addressDto) {
        int idNow = addressDto.getIdDto();
        Address address = repository.findById(idNow);
        address.setCity(addressDto.getCityDto());
        address.setStreet(addressDto.getStreetDti());
        address.setHouseNumber(addressDto.getHouseNumberDto());

    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);

    }
}
