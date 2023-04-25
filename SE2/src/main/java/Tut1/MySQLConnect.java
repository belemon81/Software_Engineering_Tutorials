package Tut1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class MySQLConnect {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bookdb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "UnDearth1412";

    public static void main(String args[]) {
        try {
            Connection con = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            //System.out.println("Connection to DB succeed !");
            Statement stm = con.createStatement();
            String query = "SELECT * FROM book";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                System.out.println("Book ID: " + rs.getInt(1));
                System.out.println("Book Title: " + rs.getString(2));
                System.out.println("Book Author: " + rs.getString(3));
            }
//            System.out.println("Book Price: " + rs.getString(4));
            System.out.println(".....................");
            con.close();
        } catch (Exception ex) {
//            ex.printStackTrace();
            System.err.println("Connection to DB failed !");
        }
    }
}