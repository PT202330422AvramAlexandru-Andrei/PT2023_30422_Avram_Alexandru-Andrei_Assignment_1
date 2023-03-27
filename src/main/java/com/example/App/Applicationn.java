package com.example.App;

import Logic.PolynomialController;
import Model.BadStringException;
import Model.Polynomial;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Applicationn extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view.fxml"));
        Scene scene = new Scene(root, 600, 350);
        //scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setTitle("AAA's Polynomial Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws BadStringException {
        launch();

    }
}