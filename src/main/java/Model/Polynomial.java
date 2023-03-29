package Model;

import java.util.*;

public class Polynomial {
    public Map<Integer, Double> monomials;

    public Polynomial() {
        monomials = new HashMap<>();
    }

    public Polynomial(Map<Integer, Double> monomials) {
        this.monomials = monomials;
    }

    public Integer getDegree() {
        return monomials.keySet().stream().max(Integer::compareTo).orElse(0);
    }

    public String stringOutput() {
        ArrayList<String> output = new ArrayList<>();

        for (int i = this.getDegree(); i >= 0; i--) {
            Double coef = this.monomials.get(i);

            if (coef == null || coef == 0) {
                continue;
            }

            String sign = (coef < 0 && i != this.getDegree()) ? "-" : (output.isEmpty() ? "" : "+");

            System.out.println(sign);

            String term = "";

            if (coef != 1 || i == 0) {
                term += String.format("%.2f", Math.abs(coef));
            }

            if (i > 0) {
                term += "x";
                if (i > 1) {
                    term += "^" + i;
                }
            }

            if (this.monomials.get(i) < 0) {
                sign = "-";
            }
            output.add(sign + term);
        }

        if (output.isEmpty()) {
            return "0";
        } else {
            return String.join("", output);
        }
    }

    public Polynomial(Polynomial polynomial) {
        this.monomials = new HashMap<>(polynomial.monomials);
    }

    public Polynomial(String stringPoly) throws BadStringException {

        monomials = new HashMap<>();

        stringPoly = stringPoly.replaceAll("\\s+", "");
        stringPoly = stringPoly.replaceAll("x\\^0", "1");
        String[] terms = stringPoly.split("(?=[+-])");

        for (String term : terms) {

            if (!term.matches("^[+-]?\\d*(\\.\\d+)?x\\^?\\d*$") && !term.matches("^[+-]?x\\^?\\d*$") && !term.matches("^[+-]?\\d*(\\.\\d+)?$") && !term.matches("^[+-]?x$")) {
                throw new BadStringException("Invalid term: " + term);
            }

            if (term.isEmpty()) {
                continue;
            }

            String[] parts = term.split("x\\^?");
            for (String part : parts) {
                System.out.println(part);
            }

            Integer exponent;
            Double coef;

            if (term.equals("x") || term.equals("+x")) {
                if (monomials.containsKey(1)) {
                    monomials.put(1, monomials.get(1) + 1.0);
                } else {
                    monomials.put(1, 1.0);
                }
                continue;
            } else if (term.equals("-x")) {
                if (monomials.containsKey(1)) {
                    monomials.put(1, monomials.get(1) - 1.0);
                } else {
                    monomials.put(1, -1.0);
                }
                continue;
            } else if (parts[0].equals("+")) {
                coef = 1.0;
                exponent = Integer.parseInt(parts[1]);
                monomials.put(exponent, coef);
                continue;
            } else if (parts[0].equals("-")) {

                coef = -1.0;
                exponent = Integer.parseInt(parts[1]);
                monomials.put(exponent, coef);
                continue;
            } else if (parts.length == 1) {
                coef = Double.parseDouble(parts[0]);
                exponent = 0;
                //}
            } else if (parts[0].equals("")) {
                coef = 1.0;
                exponent = Integer.parseInt(parts[1]);
            } else {
                coef = Double.parseDouble(parts[0]);
                exponent = Integer.parseInt(parts[1]);
            }

            if (term.contains("x") && !term.contains("^")) {
                exponent = 1;
            }
            System.out.println("Group: " + coef + " " + exponent + "\n\n");

            if (monomials.containsKey(exponent)) {
                coef += monomials.get(exponent);
            }
            monomials.put(exponent, coef);
        }
        System.out.println("Here you go: " + monomials + "\n\n");
    }

    public boolean isZero() {
        return monomials.isEmpty();
    }

    public Double leadingCoeff() {
        return monomials.get(this.getDegree());
    }

    public Map<Integer, Double> getMonomials() {
        return monomials;
    }

    public void setMonomials(Map<Integer, Double> monomials) {
        this.monomials = monomials;
    }
}
