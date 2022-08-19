package com.example.mealplanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sequel {

    static String url = "jdbc:mysql://localhost:3306/recipedb?allowPublicKeyRetrieval=true&useSSL=false";
    static String user = "root";
    static String password = "test";
    static Boolean accountAlreadyExists = false;
    static Boolean passwordMatch = false;

    public static void addUser(String firstName, String lastName, String Email, String username, String pass) {
        String sql = "INSERT INTO usereditor.useraccount (FirstName, LastName, Email, UserName, Password) Values(?, ?, ?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, Email);
            pst.setString(4, username);
            pst.setString(5, pass);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            accountAlreadyExists = true;
        }
    }

    // select password from user where email == email input, if password == password log in
    public static void accountLogin(String username, String pass) {
        String sql = "Select Password from usereditor.useraccount where UserName=(?)";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                if (pass.equals(rs.getString("password"))) {
                    System.out.println("password match");
                    passwordMatch = true;
                } else {
                    System.out.println("access denied, try again");
                    passwordMatch = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
