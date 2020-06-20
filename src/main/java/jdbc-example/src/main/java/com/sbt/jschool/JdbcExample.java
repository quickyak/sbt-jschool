package com.sbt.jschool;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver"); //Говорим каким драйвером работать - Загрузка класса -
        try (
//        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "SA", "")) {
                Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/~/test", "SA", "")) {
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5435/~/test", "SA", "")) {
//            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "SA", "")) {  //in memory

            connection.setAutoCommit(false);
//            connection.setAutoCommit(true);


            String tableName ="CLIENT";
            String sqlStatement;
            sqlStatement = "CREATE TABLE " + tableName + " (id integer primary key, name varchar(255));";
            doCreateTable(connection,tableName,sqlStatement);

            if (true==true) return;


//            connection.commit();


            sqlStatement = "select * from client;";
            System.out.println("Start ============= " + sqlStatement);
            doTestPreparedStatement(connection, sqlStatement);
            System.out.println("End ============= " + sqlStatement + "\n\n");

            sqlStatement = "select * from operation;";
            System.out.println("Start ============= " + sqlStatement);
            doTestPreparedStatement(connection, sqlStatement);
            System.out.println("End ============= " + sqlStatement + "\n\n");

            sqlStatement = "select * from client; select * from operation;";
            System.out.println("Start ============= " + sqlStatement);
            doTestPreparedStatement(connection, sqlStatement);
            System.out.println("End ============= " + sqlStatement + "\n\n");

            if (true==true) return;




//            System.out.println("===========================");
//            //РЕЖИМЫ ЛУЧШЕ НЕ МЕНЯТЬ
//            System.out.println(connection.getMetaData().supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));  //Оставлять умолчательные настройки
//            System.out.println(connection.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
//            System.out.println(connection.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
//            System.out.println("===========================");
//
//            System.out.println(connection.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY));//Оставлять умолчательные настройки
//            System.out.println(connection.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE));
//
//            System.out.println(connection.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY));
//            System.out.println(connection.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE));
//
//            System.out.println(connection.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY));
//            System.out.println(connection.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE));
//
//            System.out.println(connection.getMetaData().supportsResultSetHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT));
//            System.out.println(connection.getMetaData().supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT));

            String sql;
            sql = "select name from client where id between ? and ?;";

//            try (Statement statement = connection.createStatement()) {
            try (PreparedStatement preparedStatement
                         = connection.prepareStatement(sql)) {
//                preparedStatement.setInt(1, 345);
                preparedStatement.setInt(1, 1);
                preparedStatement.setInt(2, 10);


                int intName = 6;

                preparedStatement.setInt(2, -1 * intName);
                preparedStatement.setString(3, "MyName" + intName);
                preparedStatement.addBatch();


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

    static void doTestPreparedStatement(Connection connection,
                                        String sqlStatement) {
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean retval = false;
        try {
            assert pstmt != null;
            retval = pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs;
        int count = -1;
        do {
            if (retval == false) {
                try {
                    count = pstmt.getUpdateCount();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (count == -1) {
                    // no more results
                    break;
                } else {
                    // process update count
                }
            } else { // ResultSet
                try {
                    rs = pstmt.getResultSet();
                    // process ResultSet
                    while (rs.next()) {
                        System.out.println(rs.getInt(1));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
//                        Chapter 13 Statements 105
                //source jdbc 4 1


            }
            try {
                retval = pstmt.getMoreResults();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } while (true) ;
    }

    static void doCreateTable(Connection connection,
                              String tableName,
                              String sqlStatementCreateTable) throws SQLException {


        Statement statement = connection.createStatement();
        ResultSet rs;
        boolean exec = false;
        int intUpdate=0;
        boolean blnTableExists = false;

        //Table exists?
        String sqlStatementLocal = "SELECT  *" +
                " FROM    INFORMATION_SCHEMA.TABLES" +
                "   WHERE   TABLE_NAME      = '" + tableName + "'" +
                " AND TABLE_SCHEMA    = 'PUBLIC'";
        rs = statement.executeQuery(sqlStatementLocal);

        while (rs.next()) {
            System.out.println(rs.getString(1));
            blnTableExists = true;
        }

        rs.close();
        statement.close();


/*        if (blnTableExists) {
            sqlStatementLocal = "DROP TABLE " + tableName + ";";
            intUpdate = statement.executeUpdate(sqlStatementLocal);
            // execute
            // true indicates that the execute method returned a result set object which can be retrieved using getResultSet method.
            //false indicates that the query returned an int value or void. execute method can run both select and insert/update statements.

            // executeUpdate method execute sql statements that insert/update/delete data at the database. This method return int value representing number of records affected; Returns 0 if the query returns nothing. The method accepts only non-select statements.
        }*/

        if (!blnTableExists) {
            intUpdate = statement.executeUpdate(sqlStatementCreateTable);
            System.out.println(intUpdate);
        }


    }
}

