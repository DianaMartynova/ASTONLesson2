package com.example.astonlesson2.repository;

import com.example.astonlesson2.model.User;
import com.example.astonlesson2.repository.dao.JDBCDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepositoryImpl implements RepositoryUser {
    private JDBCDao jdbcDao = new JDBCDao();
    private PreparedStatement prepareStatement = null;
    private Connection connection = null;

    @Override
    public User findById(int id) {
        jdbcDao.connectDB();
        User user = new User();

        String findBy = "SELECT * FROM user WHERE id = ?";
        try {
            connection = jdbcDao.getConnection();
            prepareStatement = connection.prepareStatement(findBy);
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                 user = new User();
                user.setId(resultSet.getInt("id"));
                user.setNameFIO(resultSet.getString("nameFIO"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jdbcDao.closeConnection();
        return user;

    }


    @Override
    public List<User> getAll() {
        jdbcDao.connectDB();
        User user = new User();
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try {
            connection = jdbcDao.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                user=new User();
                user.setId(resultSet.getInt("id"));
                user.setNameFIO(resultSet.getString("nameFIO"));
                userList.add(user);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public void create(User user) {
        jdbcDao.connectDB();
        String sql = "INSERT INTO user(nameFIO) VALUES(?)";
        try {
            connection = jdbcDao.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, user.getNameFIO());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jdbcDao.closeConnection();
    }

    @Override
    public void update(int id, User user) {
        jdbcDao.connectDB();
        String sql = "UPDATE user SET nameFIO = ? WHERE id=?";
        try {
            connection = jdbcDao.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, user.getNameFIO());
            prepareStatement.setInt(2, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jdbcDao.closeConnection();

    }

    @Override
    public void deleteById(int id) { //++++
        jdbcDao.connectDB();
        String sql = "DELETE FROM user WHERE id = ?";
        try {
            connection = jdbcDao.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, id);

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        jdbcDao.closeConnection();

    }


}

