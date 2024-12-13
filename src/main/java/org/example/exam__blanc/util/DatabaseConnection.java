package org.example.exam__blanc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/test1";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection = null;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {}

    // Method to establish a connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully.");
            } catch (SQLException e) {
                System.err.println("Failed to connect to database.");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Method to close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Failed to close the database connection.");
                e.printStackTrace();
            } finally {
                connection = null;
            }
        }
    }


}