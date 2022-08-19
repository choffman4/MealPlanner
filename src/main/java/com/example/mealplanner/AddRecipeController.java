package com.example.mealplanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddRecipeController implements Initializable {

    @FXML
    private Button btnCompleteRecipe;
    @FXML
    private Button btnAddURL;
    @FXML
    private Button btnAddIngredient;
    @FXML
    private ChoiceBox<String> choiceBoxCategory;
    @FXML
    private ChoiceBox<String> choiceBoxSpecific;
    @FXML
    private ChoiceBox<String> choiceBoxMeasurement;
    @FXML
    private TextField txtQuantity;
    @FXML
    private TextField txtRecipeName;
    @FXML
    private TextField txtURL;
    @FXML
    private Label LabelRecipeView;

    private Recipe newRecipe = new Recipe();

    private ObservableList<String> foodCategory = FXCollections.observableArrayList(DB.getUniqueCategories());
    private ObservableList<String> measurements = FXCollections.observableArrayList("ea", "count", "oz", "lb", "bunch", "cups");
    private ObservableList<String> empty = FXCollections.observableArrayList();

    @FXML
    protected void onExitButtonClick(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "homepage-view.fxml");
    }

    /**
     * resets all entries and recipe
     */
    @FXML
    protected void onResetButtonClick(){
        txtRecipeName.setText("");
        txtQuantity.setText("");
        txtURL.setText("");
        choiceBoxSpecific.setItems(empty);
        choiceBoxMeasurement.getSelectionModel().clearSelection();
        choiceBoxCategory.getSelectionModel().clearSelection();
        newRecipe = new Recipe();
        updateRecipeText();
    }

    @FXML
    protected void onNameButtonClick(){
        newRecipe.recipeName = txtRecipeName.getText();
        updateRecipeText();
    }

    @FXML
    protected void onURLButtonClick(){
        newRecipe.recipeURL = txtURL.getText();
        updateRecipeText();
    }


    //when btnCompleteRecipe is clicked, print the recipe to the console
    @FXML
    protected void onCompleteButtonClick() throws IOException, ParseException {
        System.out.println(newRecipe.toString());
        //convert newRecipe to JSON and print to console
        System.out.println(newRecipe.toJSON());
        onResetButtonClick();
    }

    @FXML
    protected void onIngredientButtonClick(){
        Item newIng = new Item(choiceBoxSpecific.getValue(), Double.parseDouble(txtQuantity.getText()), choiceBoxMeasurement.getValue(), choiceBoxCategory.getValue());
//        newRecipe.addIngredient(newIng);
        updateRecipeText();
    }

    /**
     * updates the field underneath entries to display the current recipe being built.
     */
    private void updateRecipeText() {
        System.out.println(newRecipe);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //Adds categories to first choicebox
        choiceBoxCategory.setItems(foodCategory);
        choiceBoxMeasurement.setItems(measurements);
        choiceBoxCategory.setOnAction(this::getFoodCategory);
        System.out.println("init");
    }

    /**
     * When a category is selected, this runs and fills the selection choicebox with the category's items
     * @param event
     */
    public void getFoodCategory(ActionEvent event) {
        String foodCategory = choiceBoxCategory.getValue();
        LabelRecipeView.setText(foodCategory);
        ObservableList<String> foodSpecific = FXCollections.observableArrayList(DB.getCategorySpecifics(choiceBoxCategory.getValue()));
        choiceBoxSpecific.setItems(foodSpecific);
    }

    /***
     * Displays the selected food at the bottom left of the pane when specific food is chosen
     * @param event
     */
    public void getFoodSpecific(ActionEvent event) {
        //Gets the value of the category and specific food, then displays them
        String category = choiceBoxCategory.getValue();
        String specific = choiceBoxSpecific.getValue();
        LabelRecipeView.setText(category + ": " + specific);
    }

}
