package com.example.mealplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RecipeViewController implements Initializable {
    @FXML
    private Button btnAddNewRecipe;

    @FXML
    private Button btnAddRecipeToList;

    @FXML
    private Button btnNextRecipe;

    @FXML
    private Button btnPrevRecipe;

    @FXML
    private Button btnViewShoppingList;

    @FXML
    private Label labelRecipeView;

    @FXML
    private Label labelMealPlanView;

    @FXML
    void AddNewRecipe(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "addRecipe-view.fxml");
    }

    @FXML
    void AddRecipeToList(ActionEvent event) {

    }

    @FXML
    void NextRecipe(ActionEvent event) {

    }

    @FXML
    void PrevRecipe(ActionEvent event) {

    }

    @FXML
    void ViewShoppingList(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "shoppingList-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RecipeJSON.ReadJSON();
    }


}