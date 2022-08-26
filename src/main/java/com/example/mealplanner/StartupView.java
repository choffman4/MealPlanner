package com.example.mealplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartupView implements Initializable {

    @FXML
    private Label labelConn;

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageView1.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/startPictures/StartPagePhoto1.png")));
        imageView2.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/startPictures/StartPagePhoto2.png")));
//        if (DB.isConnected()) {
//            labelConn.setText("Connection Status:\r\nConnected");
//        } else {
//            labelConn.setText("Connection Status:\r\nNot Connected");
//        }
    }

    @FXML
    protected void onStartButtonClicked(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "chooserecipe.fxml");
    }

}
