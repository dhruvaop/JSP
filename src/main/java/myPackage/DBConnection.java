package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:derby:E:\\Java\\ChampionsLeague\\FootBallDB;create=true";
    private static final String DRIVER_NAME = "org.apache.derby.jdbc.EmbeddedDriver";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME); // Load the JDBC Driver
            conn = DriverManager.getConnection(JDBC_URL); // Get a connection to the database
            System.out.println("Connection Established Successfully...");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: JDBC Driver not found. " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error: Failed to connect to the database. " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for debugging
        }
        return conn;
    }

    // This main method is for testing purposes only
    public static void main(String[] args) {
        Connection testConnection = getConnection();
        if (testConnection != null) {
            System.out.println("Test connection successful!");
            try {
                testConnection.close();
            } catch (SQLException e) {
                System.out.println("Error closing test connection: " + e.getMessage());
            }
        } else {
            System.out.println("Test connection failed!");
        }
    }
}
