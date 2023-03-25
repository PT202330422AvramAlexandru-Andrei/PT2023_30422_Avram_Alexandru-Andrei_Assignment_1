package com.example.App;

import Logic.PolynomialController;
import Model.Polynomial;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private Label result;

    @FXML
    TextField poly1_text;
    @FXML
    TextField poly2_text;


    @FXML
    protected void button() {
    }

    @FXML
    protected void add() {
        String input1 = poly1_text.getText();
        String input2 = poly2_text.getText();

        PolynomialController pc = new PolynomialController();

        Polynomial p1 = new Polynomial(input1);
        Polynomial p2 = new Polynomial(input2);
        Polynomial p3 = new Polynomial();

        p3 = pc.addPolynomials(p1, p2);
        result.setText(p3.stringOutput());
    }

    @FXML
    protected void subtract() {
        String input1 = poly1_text.getText();
        String input2 = poly2_text.getText();

        PolynomialController pc = new PolynomialController();

        Polynomial p1 = new Polynomial(input1);
        Polynomial p2 = new Polynomial(input2);
        Polynomial p3 = new Polynomial();

        p3 = pc.subtractPolynomials(p1, p2);
        result.setText(p3.stringOutput());
    }

    @FXML
    protected void multiply() {
        String input1 = poly1_text.getText();
        String input2 = poly2_text.getText();

        PolynomialController pc = new PolynomialController();

        Polynomial p1 = new Polynomial(input1);
        Polynomial p2 = new Polynomial(input2);
        Polynomial p3 = new Polynomial();

        p3 = pc.multiplyPolynomials(p1, p2);
        result.setText(p3.stringOutput());
    }

    @FXML
    protected void divide() {
        String input1 = poly1_text.getText();
        String input2 = poly2_text.getText();

        PolynomialController pc = new PolynomialController();

        Polynomial p1 = new Polynomial(input1);
        Polynomial p2 = new Polynomial(input2);
        Polynomial p3 = new Polynomial();

        p3 = pc.dividePolynomials(p1, p2);
        result.setText(p3.stringOutput());
    }

    @FXML
    protected void differentiate() {
        String input1 = poly1_text.getText();

        PolynomialController pc = new PolynomialController();

        Polynomial p1 = new Polynomial(input1);
        Polynomial p3 = new Polynomial();

        p3 = pc.differentiatePolynomial(p1);
        result.setText(p3.stringOutput());
    }

    @FXML
    protected void integrate() {
        String input1 = poly1_text.getText();

        PolynomialController pc = new PolynomialController();

        Polynomial p1 = new Polynomial(input1);
        Polynomial p3 = new Polynomial();

        p3 = pc.integratePolynomial(p1);
        result.setText(p3.stringOutput());
    }
}