package com.sbt.jschool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver"); //Говорим каким драйвером работать - Загрузка класса -
//        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "SA", "")) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/~/test", "SA", "")) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("create table client;");
            }
        }



    }
}
