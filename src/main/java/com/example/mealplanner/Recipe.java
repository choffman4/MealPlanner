package com.example.mealplanner;

import org.json.simple.JSONObject;

import java.lang.reflect.Array;

import java.util.ArrayList;

public class Recipe {
    String recipeName;
    String recipeURL;
//    ArrayList<Item> ingredients = new ArrayList<>();

//    public void addIngredient(Item ing){
//        ingredients.add(ing);
//    }

    @Override
    public String toString() {
//        String ings = "";
//        for (Item item : ingredients) {
//            ings += item.toSimpleString() + "\n";
//        }
        return "Recipe{" +
                "recipeName='" + recipeName + '\'' +
                ", recipeURL='" + recipeURL + '\'' +
//                ", ingredients=" + ings +
                '}';
    }

    public JSONObject toJSON() {
        JSONObject jsonRecipe = new JSONObject();
        jsonRecipe.put("recipeName", recipeName);
        jsonRecipe.put("recipeURL", recipeURL);
        //TODO: put ingredients here in a prettier fashion
//        ArrayList<JSONObject> jsonIngredients = new ArrayList<>();
//        for (Item item : ingredients) {
//            jsonIngredients.add(item.toJSON());
//        }
//        jsonRecipe.put("ingredients", jsonIngredients);

        return jsonRecipe;
    }

}
