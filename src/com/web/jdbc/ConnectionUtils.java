package com.web.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getMyConnection() throws SQLException,
            ClassNotFoundException {

        return MySQLConUtils.getMySQLConnection();
    }

    //
    // Test Connection ...
    //
    public static void main(String[] args) throws SQLException,
            ClassNotFoundException {

        System.out.println("Get connection ... ");

        // Lấy ra đối tượng Connection kết nối vào database.
        Connection conn = com.web.jdbc.ConnectionUtils.getMyConnection();

    }
}
