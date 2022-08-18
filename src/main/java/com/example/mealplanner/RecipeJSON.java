package com.example.mealplanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RecipeJSON {

    public static void ReadJSON() {
        JSONArray jsonA = null;
        try {
            Object jsonRead = new JSONParser().parse(new FileReader("src/main/resources/com/example/mealplanner/recipe.json"));
            jsonA = (JSONArray) jsonRead;
            String recipeName;
            String recipeDirections;
//            StringBuilder recipeIngredients = new StringBuilder();


            JSONObject Recipe = (JSONObject) jsonA.get(0);
            JSONArray jRecipes = (JSONArray) Recipe.get("recipes");

            for (int i = 0; i < jRecipes.size(); i++) {
                JSONObject name = (JSONObject) jRecipes.get(i);
                JSONObject ingredients = (JSONObject) name.get("ingredients");
                recipeName = name.get("name").toString();
                recipeDirections = name.get("recipeDirections").toString();
                System.out.println(recipeName);
                System.out.println(recipeDirections);
                for (int j = 0; j < ingredients.size(); j++) {
                    System.out.println(j);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
