package org.rhsystem.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://turntable.proxy.rlwy.net:15372/railway?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "GKVLdSaKZdFRAQFhJMMkeiRraaqvKFsg";

        return DriverManager.getConnection(url, user, password);
    }
    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            System.out.println("Conectado");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Nn conectou: " + e.getMessage());
        }
    }
}