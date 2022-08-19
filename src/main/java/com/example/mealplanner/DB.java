package com.example.mealplanner;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    static String url = "jdbc:mysql://localhost:3306/recipedb?allowPublicKeyRetrieval=true&useSSL=false";
    static String user = "root";
    static String dbPassword = "test";

    public static boolean addRecipe(String recipeName, String recipeURL) {
        String sql = "INSERT INTO recipedb.recipe(RecipeName, RecipeURL) Values(?,?)";
        try {
            Connection con = DriverManager.getConnection(url, user, dbPassword);
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, recipeName);
            pst.setString(2, recipeURL);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addItem(String ingName) {
        String sql = "INSERT INTO recipedb.ingredient(ItemName) Values(?)";
        try {
            Connection con = DriverManager.getConnection(url, user, dbPassword);
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, ingName);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addRecipeIngredients(int idING, int idRECIPE, double qty, String type) {
        String sql = "INSERT INTO recipedb.recipeingredients(ItemID, RecipeID, Quantity, Type) Values(?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection(url, user, dbPassword);
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, idING);
            pst.setInt(2, idRECIPE);
            pst.setDouble(3, qty);
            pst.setString(4, type);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getRecipeName(int id) {
        String recipeName = null;
        String sql = "SELECT RecipeName FROM recipedb.recipe WHERE RecipeID = (?)";
        try {
            Connection con = DriverManager.getConnection(url, user, dbPassword);
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                recipeName = rs.getString("recipeName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipeName;
    }

    //get recipe ingredients through recipeingredients table, with name from ingredient table
    //TODO: replace names with correct ones once we have the database set up
    public static String getRecipeIngredients(int id) {
        String recipeIngredients = null;
        String sql = "SELECT ItemName, Quantity, Type FROM recipedb.recipeingredients JOIN recipedb.ingredient ON recipedb.recipeingredients.ItemID = recipedb.ingredient.ItemID WHERE RecipeID = (?)";
        try {
            Connection con = DriverManager.getConnection(url, user, dbPassword);
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                recipeIngredients = rs.getString("ItemName") + " " + rs.getDouble("Quantity") + " " + rs.getString("Type");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipeIngredients;
    }

    public static ArrayList<String> getUniqueCategories(){
        ArrayList<String> categories = new ArrayList<String>();
        String sql = "SELECT DISTINCT ingCat FROM recipedb.ingredient";
        try {
            Connection con = DriverManager.getConnection(url, user, dbPassword);
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                categories.add(rs.getString("ingCat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
        return categories;
    }
}
