package Tut1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class Task {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/studentdb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "UnDearth1412";

    public static void main(String args[]) {
        try {
            Connection con = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection to DB succeed !");
            Statement stm = con.createStatement();
            String query = "SELECT * FROM student";
            ResultSet rs = stm.executeQuery(query);
            System.out.println("STUDENT TABLE-----------------");
            System.out.println("ID  |Name         |Age  |Grade");
            while (rs.next()) {
                System.out.format("%-4d|%-13s|%-5d|%-5.2f%n", rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getFloat(4));
            }
            System.out.println("------------------------------\n");
            stm = con.createStatement();
            query = "SELECT * FROM course";
            rs = stm.executeQuery(query);
            System.out.println("COURSE TABLE-----------------------------------");
            System.out.println("ID  |Name                          |No. student");
            while (rs.next()) {
                System.out.format("%-4d|%-30s|%-5d%n", rs.getInt(1), rs.getString(2),
                        rs.getInt(3));
            }
            System.out.println("-----------------------------------------------");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Connection to DB failed !");
        }
    }
}