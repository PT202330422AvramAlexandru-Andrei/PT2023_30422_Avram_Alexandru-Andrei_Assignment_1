package Logic;

import Model.Polynomial;

import java.util.HashMap;
import java.util.Map;

public class PolynomialController {

    public Polynomial addPolynomials(Polynomial polynomial1, Polynomial polynomial2) {
        Map<Integer, Double> result = new HashMap<>(polynomial1.monomials);

        for (Map.Entry<Integer, Double> entry : polynomial2.monomials.entrySet()) {
            int degree = entry.getKey();
            double coeff = entry.getValue();
            result.put(
                    degree,
                    result.getOrDefault(degree, 0.0) + coeff

            );
        }

        return new Polynomial(result);
    }

    public Polynomial subtractPolynomials(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Double> entry : polynomial1.monomials.entrySet()) {
            if (polynomial2.monomials.containsKey(entry.getKey())) {
                result.monomials.put(
                        entry.getKey(),
                        entry.getValue() - polynomial2.monomials.get(entry.getKey())
                );
            } else {
                result.monomials.put(
                        entry.getKey(),
                        entry.getValue()
                );
            }
        }

        for (Map.Entry<Integer, Double> entry : polynomial2.monomials.entrySet()) {
            if (!polynomial1.monomials.containsKey(entry.getKey())) {
                result.monomials.put(
                        entry.getKey(),
                        -entry.getValue()
                );
            }
        }

        return result;
    }

    public Polynomial multiplyPolynomials(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Double> entry1 : polynomial1.monomials.entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : polynomial2.monomials.entrySet()) {
                int exponent = entry1.getKey() + entry2.getKey();
                double coefficient = entry1.getValue() * entry2.getValue();
                if (result.monomials.containsKey(exponent)) {
                    coefficient += result.monomials.get(exponent);
                }
                result.monomials.put(exponent, coefficient);
            }
        }

        return result;
    }

    public Polynomial dividePolynomials(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Double> dividendTerm : polynomial1.monomials.entrySet()) {
            int dividendExponent = dividendTerm.getKey();
            double dividendCoefficient = dividendTerm.getValue();

            int highestMatchingExponent = Integer.MIN_VALUE;
            double highestMatchingCoefficient = 0;
            for (Map.Entry<Integer, Double> divisorTerm : polynomial2.monomials.entrySet()) {
                int divisorExponent = divisorTerm.getKey();
                double divisorCoefficient = divisorTerm.getValue();

                if (divisorExponent <= dividendExponent && divisorExponent > highestMatchingExponent) {
                    highestMatchingExponent = divisorExponent;
                    highestMatchingCoefficient = divisorCoefficient;
                }
            }

            if (highestMatchingExponent == Integer.MIN_VALUE) {
                continue;
            }

            double quotientCoefficient = dividendCoefficient / highestMatchingCoefficient;
            int quotientExponent = dividendExponent - highestMatchingExponent;
            result.monomials.put(quotientExponent, quotientCoefficient);
        }
        return result;
    }

    public Polynomial differentiatePolynomial(Polynomial polynomial) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Double> entry : polynomial.monomials.entrySet()) {
            if (entry.getKey() != 0) {
                result.monomials.put(
                        entry.getKey() - 1,
                        entry.getValue() * entry.getKey()
                );
            }
        }

        return result;
    }

    public Polynomial integratePolynomial(Polynomial polynomial) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Double> entry : polynomial.monomials.entrySet()) {
            result.monomials.put(
                    entry.getKey() + 1,
                    entry.getValue() / (entry.getKey() + 1)
            );
        }

        return result;
    }
}
