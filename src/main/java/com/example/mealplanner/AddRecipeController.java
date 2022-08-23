package com.example.mealplanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;
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
    private Label labelRecipe;

    private Recipe newRecipe = new Recipe();
    private ArrayList<Item> newIngredients = new ArrayList<>();

    private ObservableList<String> foodCategory = FXCollections.observableArrayList(DB.getUniqueCategories());
    private ObservableList<String> measurements = FXCollections.observableArrayList("ea", "count", "oz", "lb", "bunch", "cups");
    private ObservableList<String> empty = FXCollections.observableArrayList();

    @FXML
    protected void onExitButtonClick(ActionEvent event) throws IOException {
        ChangeScene.changeScene(event, "chooserecipe.fxml");
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
        newIngredients = new ArrayList<>();
        setLabelText();
    }

    @FXML
    protected void onNameButtonClick(){
        newRecipe.recipeName = txtRecipeName.getText();
        setLabelText();
    }

    @FXML
    protected void onURLButtonClick(){
        newRecipe.recipeURL = txtURL.getText();
        setLabelText();
    }


    /**
     * when complete button is clicked, this adds a recipe to the database and assigns ingredients for it in recipeingredients
     */
    @FXML
    protected void onCompleteButtonClick() throws IOException, ParseException {
        if(newRecipe.recipeName != null && newRecipe.recipeName != "" && newRecipe.recipeURL != null && newIngredients.size() > 0){
            DB.addRecipe(newRecipe.recipeName, newRecipe.recipeURL);
            int newID = DB.getRecipeID(newRecipe.recipeName);
            for (Item ingredient : newIngredients) {
                DB.addRecipeIngredients(ingredient.itemID, newID, ingredient.itemQuantity, ingredient.itemType);
            }
            onResetButtonClick();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Please fill out all fields");
            alert.showAndWait();
        }

    }

    @FXML
    protected void onIngredientButtonClick(){
        Item newIng = new Item(choiceBoxSpecific.getValue(), DB.getItemID(choiceBoxSpecific.getValue()), Double.parseDouble(txtQuantity.getText()), choiceBoxMeasurement.getValue());
        newIngredients.add(newIng);
        setLabelText();
    }

    /**
     * updates the field underneath entries to display the current recipe being built.
     */


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //Adds categories to first choicebox
        choiceBoxCategory.setItems(foodCategory);
        choiceBoxMeasurement.setItems(measurements);
        choiceBoxCategory.setOnAction(this::getFoodCategory);
    }

    /**
     * When a category is selected, this runs and fills the selection choicebox with the category's items
     * @param event
     */
    public void getFoodCategory(ActionEvent event) {
        String foodCategory = choiceBoxCategory.getValue();
//        textFlowRecipe.setAccessibleText(foodCategory);
        ObservableList<String> foodSpecific = FXCollections.observableArrayList(DB.getCategorySpecifics(choiceBoxCategory.getValue()));
        choiceBoxSpecific.setItems(foodSpecific);
    }

    public void setLabelText() {
        String allIngredients = "";
        for (Item ingredient : newIngredients) {
            allIngredients += ingredient.itemName + " " + ingredient.itemQuantity + " " + ingredient.itemType + "\r\n";
        }
        labelRecipe.setText("New Recipe:\r\n\r\nName: " + newRecipe.recipeName + "\r\n\r\nURL: " + newRecipe.recipeURL + "\r\n\r\nIngredients: \r\n" + allIngredients);
    }
}
