package com.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryData {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
// Lấy ra đối tượng Connection kết nối vào DB.
        Connection connection = ConnectionUtils.getMyConnection();

        // Tạo đối tượng Statement.
        Statement statement = connection.createStatement();

        String sql = "select * from student order by last_name";

        // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
        ResultSet rs = statement.executeQuery(sql);

        // Duyệt trên kết quả trả về.
        while(rs.next()){
            // retrieve data from result set row
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            // create new student objects

            System.out.println("F Name:"+firstName);
            System.out.println("L Name:"+lastName);
            System.out.println("Email:"+ email );
        }
        // Đóng kết nối
        connection.close();
    }
}
