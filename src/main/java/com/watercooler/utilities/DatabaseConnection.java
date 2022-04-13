package com.watercooler.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        System.out.println(createConnection());
    }

    public static Connection createConnection() {
        try {
            Connection connection = DriverManager.getConnection(String.format(
                    "jdbc:postgresql://%s:%s/%s?user=%s&password=%s",
                    System.getenv("HOST"),
                    System.getenv("PORT"),
                    System.getenv("DB"),
                    System.getenv("USERNAME"),
                    System.getenv("PASSWORD")
                    )
            );
            return connection;
        } catch(SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
