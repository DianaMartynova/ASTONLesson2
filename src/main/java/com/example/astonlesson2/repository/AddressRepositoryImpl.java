package com.example.astonlesson2.repository;

import com.example.astonlesson2.model.Address;
import com.example.astonlesson2.repository.dao.JDBCDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AddressRepositoryImpl implements RepositoryAddress {
    private JDBCDao jdbcDao = new JDBCDao();
    private PreparedStatement prepareStatement = null;
    private Connection connection = null;

    @Override
    public Address findById(int id) {
        jdbcDao.connectDB();
        String sql = "SELECT * FROM address WHERE id = ?";
        Address address = new Address();
        try {
            connection = jdbcDao.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                address = new Address();
                address.setId(resultSet.getInt("id"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setHouseNumber(resultSet.getString("house_number"));
            }

        } catch (SQLException e) {
           // throw new RuntimeException(e);
        }
        jdbcDao.closeConnection();
        return address;
    }

    @Override
    public List<Address> getAll() {
        jdbcDao.connectDB();
        String sql = "SELECT * FROM address";
        Address address = new Address();
        List<Address> addresses = new ArrayList<>();
        try {
            connection = jdbcDao.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                address = new Address();
                address.setId(resultSet.getInt("id"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setHouseNumber(resultSet.getString("house_number"));
                addresses.add(address);
            }

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        jdbcDao.closeConnection();
        return addresses;
    }

    @Override
    public void create(Address address) {
        jdbcDao.connectDB();
        String sql = "INSERT INTO address(city,street,house_number) VALUES(?,?,?)";
        try {
            connection = jdbcDao.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, address.getCity());
            prepareStatement.setString(2, address.getStreet());
            prepareStatement.setString(3, address.getHouseNumber());



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jdbcDao.closeConnection();

    }

    @Override
    public void update(int id, Address address) {
        jdbcDao.connectDB();
        String sql = "UPDATE address SET city=?,street = ?, house_number = ? WHERE id = ?";
        try {
            connection = jdbcDao.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, address.getCity());
            prepareStatement.setString(2, address.getStreet());
            prepareStatement.setString(3, address.getHouseNumber());
            prepareStatement.setInt(4, id);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jdbcDao.closeConnection();

    }


    @Override
    public void deleteById(int id) {
        jdbcDao.connectDB();
        String sql = "DELETE FROM address WHERE id = ?";
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

