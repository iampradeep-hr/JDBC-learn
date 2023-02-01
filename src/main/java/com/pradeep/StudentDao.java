package com.pradeep;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

    public static boolean insertToDb(Student student){
        //jdbc code
        boolean f=false;
        try {
            Connection con=CP.createConnection();
            String q="insert into students(sname,sphone,scity) values(?,?,?)";
            //dynamic preparedstatement
            PreparedStatement pstmt=con.prepareStatement(q);
            //set value parameter
            pstmt.setString(1,student.getStudentName());
            pstmt.setString(2,student.getStudentPhone());
            pstmt.setString(3,student.getStudentCity());
            //executeUpdate(no data expected)
            pstmt.executeUpdate();
            f=true;
        }catch (Exception e){
            System.out.println(e);
        }
        return f;
    }
    public static boolean deleteStudent(int sid){
        //jdbc code
        boolean f=false;
        try {
            Connection con=CP.createConnection();
            String q="delete from students where sid=?";
            //dynamic preparedstatement
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setInt(1,sid);
            pstmt.executeUpdate();
            f=true;
        }catch (Exception e){
            System.out.println(e);
        }
        return f;
    }

    public static void showAllStudents(){
        //jdbc code

        try {
            Connection con=CP.createConnection();
            String q="select * from students";
            //dynamic preparedstatement
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(q);
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String phone=resultSet.getString(3);
                String city=resultSet.getString("scity");
                System.out.println(
                        "Student{" +
                                "studentId=" + id +
                                ", studentName='" + name + '\'' +
                                ", studentPhone='" + phone + '\'' +
                                ", studentCity='" + city + '\'' +
                                '}'+"\n-------------------------------------------------------------------\n"
                );
            }


        }catch (Exception e){
            System.out.println(e);
        }

    }
}
