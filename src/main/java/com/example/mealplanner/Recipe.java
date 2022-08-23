package com.example.mealplanner;

import org.json.simple.JSONObject;

import java.lang.reflect.Array;

import java.util.ArrayList;

public class Recipe {
    String recipeName;
    String recipeURL;

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeName='" + recipeName + '\'' +
                ", recipeURL='" + recipeURL + '\'' +
                '}';
    }

}
