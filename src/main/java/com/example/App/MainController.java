package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static java.lang.Thread.sleep;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onByeButtonClick() throws InterruptedException {
        welcomeText.setText("Application will explode!");
        sleep(3000);
        welcomeText.setText("Goodbye!");
    }

    //@FXML
    //protected void button() {
    //    poly1.setText("button");
    //}
}