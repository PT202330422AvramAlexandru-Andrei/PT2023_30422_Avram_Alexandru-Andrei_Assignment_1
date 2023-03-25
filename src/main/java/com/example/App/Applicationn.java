package com.example.App;

import Logic.PolynomialController;
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
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.viewXML/view.fxml"));
        //FXMLLoader.load(getClass().getResource("/FXMLe1.fxml"));
        Scene scene = new Scene(root, 480, 480);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        Polynomial p = new Polynomial("2x^2+x+1");
        Polynomial p2 = new Polynomial("x^2-4x+3");
        Polynomial p3 = new Polynomial();

        PolynomialController pc = new PolynomialController();
        System.out.println(p2.monomials);
        p3 = pc.addPolynomials(p, p2);
        System.out.println("\n\n\nadded polynomials:\n");
        p3.print();
        p3 = pc.subtractPolynomials(p, p2);
        System.out.println("\n\n\nsubtracted polynomials:\n");
        p3.print();
        p3 = pc.multiplyPolynomials(p, p2);
        System.out.println("\n\n\nmultiplied polynomials:\n");
        p3.print();

        Polynomial p4 = new Polynomial("x^2-1");
        Polynomial p5 = new Polynomial("x+1");
        p3 = pc.dividePolynomials(p4, p5);
        System.out.println("\n\n\ndivided polynomials:\n");
        p3.print();

        System.out.println("\n\n\nnon-differentiated polynomial:\n");
        p2.print();
        System.out.println("\n\n\ndifferentiated polynomial:\n");
        p3 = pc.differentiatePolynomial(p2);
        p3.print();

        System.out.println("\n\n\nnon-integrated polynomial:\n");
        p2.print();
        p3 = pc.integratePolynomial(p2);
        System.out.println("\n\n\nintegrated polynomial:\n");
        p3.print();
    }
}