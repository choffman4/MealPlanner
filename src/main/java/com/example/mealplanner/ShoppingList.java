package com.example.mealplanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShoppingList implements Initializable {

    @FXML
    private ListView listShoppingList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void recieveSelectedRecipes(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        ArrayList<String> selectedRecipes = (ArrayList<String>) stage.getUserData();
        updateShoppingList(selectedRecipes);
    }

    @FXML
    protected void onExitButtonClicked(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "chooserecipe.fxml");
    }

    private void updateShoppingList(ArrayList<String> selectedRecipes) {
        ObservableList<String> shoppingList = FXCollections.observableArrayList();
        for (String recipe : selectedRecipes) {
            shoppingList.addAll(DB.getRecipeIngredients(Integer.parseInt(recipe)));
        }
        
        listShoppingList.setItems(shoppingList);
    }
}
