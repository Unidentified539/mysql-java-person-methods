package com.mysqldb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class sqlMethods {
    static final String DB_URL = "jdbc:mysql://localhost:3306/gitDB";
    static final String USER = "developer0";
    static final String PASS = "Azielsolomon123";
    public static List<String> ip = new ArrayList<>();
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/gitDB";

    public void createTable(String username) {
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gitDB?user=developer0&password=Azielsolomon123");
            Statement statement = connection.createStatement();

            statement.executeUpdate("create table if not exists "+username+"(age int, firstName TEXT, lastName TEXT, ipAddress TEXT, location TEXT)");
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

    }

    public void insertPerson(int userAge, String userFirstName, String userLastName, String userIpAddress, String userLocation) throws SQLException {
        // Open a connection

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            String sql = "INSERT INTO Person(age,firstName,lastName,ipAddress, location) VALUES('"+userAge+"','"+userFirstName+"','"+userLastName+"','"+userIpAddress+"','"+userLocation+"');";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public String deletePerson(String givenTable) throws ClassNotFoundException, SQLException {
        // Open a connection
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gitDB", "developer0", "Azielsolomon123");
            Statement stmt = conn.createStatement();
        ) {
            String sql = "DROP TABLE "+givenTable+"";
            stmt.executeUpdate(sql);
            return "Table deleted in given database...";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int fetchAge() {
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gitDB?user=developer0&password=Azielsolomon123");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from Person");
            while(rs.next())
            {
                return rs.getInt("age");
            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return 0;
    }
    public String fetchFirstName() {
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gitDB?user=developer0&password=Azielsolomon123");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from Person");
            while (rs.next()) {
                return rs.getString("firstName");
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    public String fetchLastName() {
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gitDB?user=developer0&password=Azielsolomon123");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from Person");
            while (rs.next()) {
                return rs.getString("lastName");
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    public String fetchipAddress() {
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gitDB?user=developer0&password=Azielsolomon123");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from Person");
            while (rs.next()) {
                return rs.getString("ipAddress");
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    public String fetchLocation() {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gitDB", "developer0", "Azielsolomon123");
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery("select * from Person");
            while (rs.next()) {
                return rs.getString("location");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeSql(String user, String sql, String url, String password) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    


    
}