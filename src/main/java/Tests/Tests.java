package Tests;

import Logic.PolynomialController;
import Model.BadStringException;
import Model.Polynomial;

import static org.junit.Assert.*;

import javafx.util.Pair;
import org.junit.Test;


public class Tests {

    @Test
    public void testAddPolynomials() throws BadStringException {
        Polynomial p1 = new Polynomial("3x^2 + 2x + 1");
        Polynomial p2 = new Polynomial("2x^2 - 4x + 3");

        Polynomial result = PolynomialController.addPolynomials(p1, p2);

        assertEquals("5.00x^2-2.00x+4.00", result.stringOutput());
    }

    @Test
    public void testSubtractPolynomials() throws BadStringException {
        Polynomial p1 = new Polynomial("3x^2 + 2x + 1");
        Polynomial p2 = new Polynomial("2x^2 - 4x + 3");

        Polynomial result = PolynomialController.subtractPolynomials(p1, p2);

        assertEquals("x^2+6.00x-2.00", result.stringOutput());
    }

    @Test
    public void testMultiplyPolynomials() throws BadStringException {
        Polynomial p1 = new Polynomial("3x^2 + 2x + 1");
        Polynomial p2 = new Polynomial("2x^2 - 4x + 3");

        Polynomial result = PolynomialController.multiplyPolynomials(p1, p2);

        assertEquals("6.00x^4-8.00x^3+3.00x^2+2.00x+3.00", result.stringOutput());
    }

    @Test
    public void testDividePolynomials() throws BadStringException {
        Polynomial p1 = new Polynomial("6x^4 - 8x^3 + x^2 + 2x + 3");
        Polynomial p2 = new Polynomial("3x^2 + 2x + 1");

        Polynomial result[] = PolynomialController.dividePolynomials(p1, p2);
        System.out.println(result[0].stringOutput() + " | " + result[1].stringOutput());

        //assertEquals("2.00x^2-4.00x+3.00", result.getKey().stringOutput());
    }

    @Test
    public void testDerivative() throws BadStringException {
        Polynomial p1 = new Polynomial("3x^2 + 2x + 1");

        Polynomial result = PolynomialController.differentiatePolynomial(p1);

        assertEquals("6.00x+2.00", result.stringOutput());
    }

    @Test
    public void testIntegrate() throws BadStringException {
        Polynomial p1 = new Polynomial("3x^2 + 2x + 1");

        Polynomial result = PolynomialController.integratePolynomial(p1);

        assertEquals("x^3+x^2+x", result.stringOutput());
    }

}