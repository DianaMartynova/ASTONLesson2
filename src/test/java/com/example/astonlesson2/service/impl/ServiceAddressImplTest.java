package com.example.astonlesson2.service.impl;

import com.example.astonlesson2.dto.AddressDto;
import com.example.astonlesson2.mapper.AddressMapper;
import com.example.astonlesson2.mapper.Impl.AddressMapperImpl;
import com.example.astonlesson2.model.Address;
import com.example.astonlesson2.model.User;
import com.example.astonlesson2.repository.AddressRepositoryImpl;
import com.example.astonlesson2.repository.RepositoryAddress;
import org.junit.Test;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ServiceAddressImplTest {
AddressMapper addressMapper =new AddressMapperImpl();
ServiceAddressImpl serviceAddress = new ServiceAddressImpl();
RepositoryAddress repositoryAddress = new AddressRepositoryImpl();
    @Test
    public void findById() {
        Address address = new Address();
        address.setId(1);
        address.setStreet("Rigina");
        address.setCity("Riga");
        address.setHouseNumber("44");
        repositoryAddress.create(address);
        AddressDto addressDto=addressMapper.addressToAddressDto(address);//маппер работает ок
        assertNotNull(addressDto);
        assertEquals(addressDto.getCityDto(),"Riga");
        address=repositoryAddress.findById(1); //метод не работает потому что не создаются таблицы в бд
        assertEquals(address.getCity(),"Riga");





    }

    @Test
    public void getAll() {
        Address address = new Address();
        address.setId(1);
        address.setStreet("Rigina");
        address.setCity("Riga");
        address.setHouseNumber("44");
        repositoryAddress.create(address);
        List<Address> addresses=repositoryAddress.getAll();//не работает
        assertNotNull(addresses);

    }

    @Test
    public void create() {
        Address address = new Address();
        address.setId(1);
        address.setStreet("Rigina");
        address.setCity("Riga");
        address.setHouseNumber("44"); //noooo
        repositoryAddress.create(address);
        assertNotNull(address);
        assertEquals(repositoryAddress.findById(1).getCity(),"Riga");
    }

    @Test
    public void update() {
        Address address = new Address();
        address.setId(1);
        address.setStreet("Rigina");
        address.setCity("Riga");
        address.setHouseNumber("44");
        Address address2 = new Address();
        address2.setId(1);
        address2.setStreet("R");
        address2.setCity("R");
        address2.setHouseNumber("4"); //не работает

        repositoryAddress.create(address);
        repositoryAddress.update(1,address2);
        assertEquals(repositoryAddress.findById(1).getCity(),"R");
    }

    @Test
    public void deleteById() {
        Address address = new Address();
        address.setId(1);
        address.setStreet("R");
        address.setCity("R");
        address.setHouseNumber("4");
        repositoryAddress.create(address);
        repositoryAddress.deleteById(1);
        assertNull(repositoryAddress.findById(1));//?????????????????????
    }
}