package com.sbt.jschool;

import sun.applet.AppletResourceLoader;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver"); //Говорим каким драйвером работать - Загрузка класса -
        try (
//        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "SA", "")) {

//                Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/~/test", "SA", "")) {

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5435/~/test", "SA", "")) {

//            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "SA", "")) {  //in memory

            // make sure autocommit is off - from https://jdbc.postgresql.org/documentation/head/query.html
            connection.setAutoCommit(false);

            String sql;
//            sql = "create table client;");
//            sql= "select id from operation order by id";
//            sql= "select * from operation where id = ?";

//            sql= "update operation set status = 'opened' where id = ?";
            sql = "update operation set status = 'closed2' where id = ?;" +
                    "insert into client values(?,?);";

//            try (Statement statement = connection.createStatement()) {
            try (PreparedStatement preparedStatement
                         = connection.prepareStatement(sql)) {
//                preparedStatement.setInt(1, 345);
                preparedStatement.setInt(1, 2);

                int intName = 6;

                preparedStatement.setInt(2, -1 * intName);
                preparedStatement.setString(3, "MyName" + intName);
                preparedStatement.addBatch();


//                for (int i = -10; i < 1000; i++) {
//                    preparedStatement.setInt(1,i);
//                    preparedStatement.addBatch();
//                }

                int[] executedStatement = preparedStatement.executeBatch();

                System.out.println(executedStatement);

                connection.commit();

//            try (Statement batchedStatement = connection.createStatement()) {
//                batchedStatement.addBatch("insert into client values (-1,'Victor')");
//                batchedStatement.addBatch("update client set name = 'Victor' where id = 0");
//                batchedStatement.addBatch("delete operation where id = 1");
//
//                batchedStatement.executeBatch();
//            }

/*

                ResultSet resultSet = preparedStatement.executeQuery();

*/


//                statement.setFetchSize(50);


//                ResultSet resultSet ;
//                resultSet=  statement.executeQuery(sql);
////                resultSet.setFetchDirection( ResultSet.FETCH_FORWARD);
//                resultSet.setFetchSize(50);

//                while (resultSet.next()){
//                    System.out.println(resultSet.getInt(1) + " : " + resultSet.getInt("ID"));
//                }

//                resultSet.close();

            }
        }


    }
}

