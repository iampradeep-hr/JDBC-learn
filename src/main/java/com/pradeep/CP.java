package com.pradeep;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
    static Connection connection;

    public static Connection createConnection() {
        //load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection
            String user = "YOUR_MYSQL_USERNAME";
            String password = "YOUR_MYSQL_PASSWORD";
            String url = "jdbc:mysql://localhost:3306/student_management";
            //replace the url with your mysql port no and database name

            connection = DriverManager.getConnection(
                    url, user, password
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
