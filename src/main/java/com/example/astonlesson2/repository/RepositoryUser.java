package com.example.astonlesson2.repository;

import com.example.astonlesson2.model.User;

import java.util.List;
import java.util.Optional;

public interface RepositoryUser {
    User findById(int id);

    List<User> getAll();


    void create(User user);

    void update(int id, User user);

    void deleteById(int id);

}
