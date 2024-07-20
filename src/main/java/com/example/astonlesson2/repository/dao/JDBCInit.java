package com.example.astonlesson2.repository.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInit {
    public static void main(String[] args) {
        JDBCInit jdbcInit = new JDBCInit();
        jdbcInit.initializeDatabase();
    }
    private PreparedStatement prepareStatement = null;
    private Connection connection = null;
    JDBCDao jdbcDao = new JDBCDao();

    public void initializeDatabase()  {
        jdbcDao.connectDB();
        String sql = "CREATE TABLE IF NOT EXISTS user" + "" +
                "id SERIAL PRIMARY KEY," +
                "nameFIO VARCHAR(40) UNIQUE";
        String sql2 = "CREATE TABLE IF NOT EXISTS address"+
                "id SERIAL PRIMARY KEY,"
                +"city VARCHAR(15)," +
                "street VARCHAR(15)," +
                "houseNumber VARCHAR(15)";
        try {
            connection = jdbcDao.getConnection();
            prepareStatement = connection.prepareStatement(sql);

            prepareStatement=connection.prepareStatement(sql2);

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        jdbcDao.closeConnection();
    }
}

