package com.example.mealplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddRecipeController {

    @FXML
    private Label LabelRecipeView;

    @FXML
    private Button btnAddIngredient;

    @FXML
    private Button btnAddName;

    @FXML
    private Button btnAddURL;

    @FXML
    private Button btnCompleteRecipe;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnReset;

    @FXML
    private ChoiceBox<?> choiceBoxMeasurement;

    @FXML
    private TextField txtIngredient;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtRecipeName;

    @FXML
    private TextField txtURL;

    @FXML
    void onCompleteButtonClick(MouseEvent event) {

    }

    @FXML
    void onExitButtonClick(ActionEvent event) {

    }

    @FXML
    void onIngredientButtonClick(MouseEvent event) {

    }

    @FXML
    void onNameButtonClick(MouseEvent event) {

    }

    @FXML
    void onResetButtonClick(MouseEvent event) {

    }

    @FXML
    void onURLButtonClick(MouseEvent event) {

    }
}
