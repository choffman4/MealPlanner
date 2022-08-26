package com.example.mealplanner;

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
