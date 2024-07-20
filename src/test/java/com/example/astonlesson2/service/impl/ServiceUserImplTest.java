package com.example.astonlesson2.service.impl;

import com.example.astonlesson2.mapper.Impl.UserMapperImpl;
import com.example.astonlesson2.mapper.UserMapper;
import com.example.astonlesson2.model.User;
import com.example.astonlesson2.repository.RepositoryUser;
import com.example.astonlesson2.repository.UserRepositoryImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ServiceUserImplTest {
    RepositoryUser repository=new UserRepositoryImpl();
    UserMapper userMapper=new UserMapperImpl();
    @Test
    public void findById() {
        User user =new User();
        user.setId(1);
        user.setNameFIO("martynova");
        repository.create(user);
        repository.findById(user.getId());//не работает
        assertEquals(repository.findById(1).getNameFIO(),"martynova");
    }

    @Test
    public void getAll() {
        User user =new User();
        user.setId(1);
        user.setNameFIO("martynova");
        repository.create(user);
        List<User> userList=repository.getAll();
        assertNotNull(userList);
    }

    @Test
    public void create() {
        User user =new User();
        user.setId(1);
        user.setNameFIO("martynova");
        repository.create(user);
        assertEquals(repository.findById(1).getNameFIO(),"martynova");
    }

    @Test
    public void update() {
        User user =new User();
        user.setId(1);
        user.setNameFIO("martynova");
        repository.create(user);
        User user2 =new User();
        user.setId(1);
        user.setNameFIO("Diana");
        repository.update(1,user2);
        assertEquals(repository.findById(1).getNameFIO(),"Diana");
    }

    @Test
    public void deleteById() {
        User user =new User();
        user.setId(1);
        user.setNameFIO("martynova");
        repository.create(user);
        repository.deleteById(1);
        assertNull(repository.getAll());

    }
}