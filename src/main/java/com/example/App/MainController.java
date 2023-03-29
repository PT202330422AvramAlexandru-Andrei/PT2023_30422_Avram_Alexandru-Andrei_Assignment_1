package com.example.App;

import Logic.PolynomialController;
import Model.BadStringException;
import Model.DivideByZeroException;
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
    protected void add() throws BadStringException {
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
    protected void subtract() throws BadStringException {
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
    protected void multiply() throws BadStringException {
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
    protected void divide() throws DivideByZeroException, BadStringException {
        String input1 = poly1_text.getText();
        String input2 = poly2_text.getText();

        PolynomialController pc = new PolynomialController();

        Polynomial p1 = new Polynomial(input1);
        Polynomial p2 = new Polynomial(input2);
        Polynomial p3[] = new Polynomial[2];

        p3 = pc.dividePolynomials(p1, p2);

        if (p3 == null) {
            result.setText("Division by 0 not allowed!!!");
            throw new DivideByZeroException("Division by 0");
        }
        else {
            result.setText(p3[0].stringOutput() + " | " + p3[1].stringOutput());
        }
    }

    @FXML
    protected void differentiate() throws BadStringException {
        String input1 = poly1_text.getText();


        if (poly1_text.getText().isEmpty()) {
            result.setText("Empty string. Please enter a polynomial in the first field.");
            throw new BadStringException("Empty string");
        }

        PolynomialController pc = new PolynomialController();

        Polynomial p1 = new Polynomial(input1);
        Polynomial p3 = new Polynomial();

        p3 = pc.differentiatePolynomial(p1);
        result.setText(p3.stringOutput());
    }

    @FXML
    protected void integrate() throws BadStringException {
        String input1 = poly1_text.getText();

        if (poly1_text.getText().isEmpty()) {
            result.setText("Empty string. Please enter a polynomial in the first field.");
            throw new BadStringException("Empty string");
        }

        PolynomialController pc = new PolynomialController();

        Polynomial p1 = new Polynomial(input1);
        Polynomial p3 = new Polynomial();

        p3 = pc.integratePolynomial(p1);
        result.setText(p3.stringOutput());
    }
}