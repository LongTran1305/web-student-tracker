package com.web.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDbUtil {
    private static DataSource dataSource;
//    public StudentDbUtil(DataSource theDataSource){
//        dataSource = theDataSource;
//    }
    public static List<Student> getStudents() throws Exception{
        List<Student> students = new ArrayList<>();
        Connection myConn = null;
        Statement mySt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = ConnectionUtils.getMyConnection();
            // create SQL statement
            String sql = "select * from student order by last_name";
            mySt=myConn.createStatement();
            // execute query
            myRs=mySt.executeQuery(sql);
            // process  result set
            while(myRs.next()){
                // retrieve data from result set row
                int id = myRs.getInt("id");
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String email = myRs.getString("email");
                // create new student objects
                Student tempStudent = new Student(id,firstName,lastName,email);
                // add it to the list of students
                students.add(tempStudent);

            }

            return students;
        } finally {
            // close JDBC objects
            close(myConn,mySt,myRs);
        }
    }



    private static void close(Connection myConn, Statement mySt, ResultSet myRs) {
        try {
            if (myRs != null){
                myRs.close();
            }
            if (mySt !=  null){
                mySt.close();
            }
            if (myConn != null){
                myConn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
