package com.example.astonlesson2.repository;

import com.example.astonlesson2.model.Address;

import java.util.List;
import java.util.Optional;

public interface RepositoryAddress{

    Address findById(int id);

    List<Address> getAll();


    void create(Address address);

    void update(int id, Address address);

    void deleteById(int id);


}