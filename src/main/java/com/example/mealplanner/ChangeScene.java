package com.example.mealplanner;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ChangeScene {

    private static Stage stage;
    private static Scene scene;

    public static void changeScene(Event event, String strFXMLFileName) throws IOException {

        URL url = new File("src/main/resources/com/example/mealplanner/" + strFXMLFileName).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
//        scene.getStylesheets().add("src/main/java/values/style.css");
        stage.show();
    }

    //change scene and send over array of selected recipes
    public static void changeScene(Event event, String strFXMLFileName, ArrayList<String> selectedRecipes) throws IOException {

        URL url = new File("src/main/resources/com/example/mealplanner/" + strFXMLFileName).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setUserData(selectedRecipes);
        stage.setScene(scene);
        stage.show();
    }
}
