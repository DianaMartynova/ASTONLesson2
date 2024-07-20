package com.example.astonlesson2.repository.dao;


import java.sql.*;
import java.util.logging.*;
import java.sql.DriverManager;
import java.sql.Connection;

/**
 * Класс JDBCDao выполняет функцию подключения к БД, закрывает ресурсы
 */
public class JDBCDao {
    private Connection connection = null;


    /**
     * Метод для подключения к базе данных
     */
    public void connectDB() {

        //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        //Имя пользователя БД
        String name = "postgres";
        //Пароль
        String password = "Diana657";
        try {
            //Загружаем драйвер
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            //Создаём соединение
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Соединение установлено");
        } catch (Exception ex) {
            //выводим наиболее значимые сообщения
            Logger.getLogger(JDBCDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Метод для закрытия ресурсов бд
     */
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(JDBCDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}