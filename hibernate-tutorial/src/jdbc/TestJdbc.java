package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/db?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "admin";

        System.out.println("connecting to database:" + jdbcUrl);

            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
                System.out.println("connection success");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Connection unsuccessful");
            }
        }
    }
