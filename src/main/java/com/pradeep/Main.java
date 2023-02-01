package com.pradeep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to my Student Management App xD:)");

        BufferedReader br=new BufferedReader(
                new InputStreamReader(System.in)
        );
        while (true){
            System.out.println("Press 1 to ADD student");
            System.out.println("Press 2 to DELETE student");
            System.out.println("Press 3 to DISPLAY student");
            System.out.println("Press 4 to EXIT the app");
            int inp = 0;
            try {
                inp=Integer.parseInt(br.readLine());
            }catch (Exception e){
                System.out.println("Invalid Input! bruh...");
            }

            switch (inp){
                case 1:
                    //add student
                    System.out.print("Name: ");
                    String name=br.readLine();
                    System.out.print("Phone: ");
                    String phone=br.readLine();
                    System.out.print("City: ");
                    String city=br.readLine();
                    Student s=new Student(name,phone,city);
                    boolean resp=StudentDao.insertToDb(s);
                    if (resp){
                        System.out.println("Student ADD Success :>");
                    }else{
                        System.out.println("Student ADD Failed :<");
                    }
                    break;

                case 2:
                    //delete student
                    System.out.print("Enter Student ID: ");
                    int id=Integer.parseInt(br.readLine());
                    StudentDao.deleteStudent(id);
                    break;
                case 3:
                    //display student
                    StudentDao.showAllStudents();
                    break;
                case 4:
                    //exit
                    System.out.println("See yah... GoodBye :p");
                    System.exit(0);//terminate jvm
                    break;
                default:
                    System.out.println("Invalid Input!");
            }

        }


    }


}