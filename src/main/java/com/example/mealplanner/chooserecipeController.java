package com.example.mealplanner;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class chooserecipeController implements Initializable {

    @FXML
    private Button addBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button addToBtn;

    @FXML
    private Button shoppingBtn;

    @FXML
    private ListView<String> myListView;

    @FXML
    private Label myRecipeLabel;

    ArrayList<String> recipes = new ArrayList<>();
    ArrayList<String> selectedRecipes = new ArrayList<>();

    String currentRecipe; // this might need to be something different

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recipes = DB.getRecipes();

        myListView.getItems().addAll(recipes);

        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                currentRecipe = myListView.getSelectionModel().getSelectedItem(); //this might have to change See line 23
//                myRecipeLabel.setText(currentRecipe);
                ArrayList<String> ingredients = DB.getRecipeIngredients(DB.getRecipeID(currentRecipe));
                String formattedIngredients = "";
                for (String ingredient : ingredients) {
                    formattedIngredients += ingredient + "\r\n";
                }
                myRecipeLabel.setText(formattedIngredients);
            }
        });
    }

    @FXML
    protected void onRecipeButtonClick(MouseEvent event) {
        selectedRecipes.add(String.valueOf(DB.getRecipeID(currentRecipe)));
    }

    @FXML
    protected void onExitButtonClick(MouseEvent event) throws IOException {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onAddButtonClick(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "addrecipe-view.fxml");
    }

    @FXML
    protected void onShoppingButtonClick(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "shoppingList.fxml", selectedRecipes);
    }
}
