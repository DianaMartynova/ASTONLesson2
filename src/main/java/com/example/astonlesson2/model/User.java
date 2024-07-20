package com.example.astonlesson2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@ToString
public class User {
    private int id;
    private String nameFIO;
    private List<Address> usersAddresses;



}
