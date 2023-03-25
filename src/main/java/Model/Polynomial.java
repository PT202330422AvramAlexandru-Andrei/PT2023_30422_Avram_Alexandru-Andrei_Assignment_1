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

    public void print() {
        for (Map.Entry<Integer, Double> i : this.monomials.entrySet()) {
            if (i.getKey().equals(0)) {
                System.out.println(i.getValue());
            } else {
                System.out.println(String.format("%.2f", i.getValue()) + " * x^" + i.getKey());
            }
        }
    }

    public String stringOutput() {
        ArrayList<String> output = new ArrayList<>();
        for (int i = this.getDegree(); i >= 0; i--) {
            Double coef = this.monomials.get(i);
            if (coef == null) {
                continue;
            }
            String sign = (coef < 0 && i != this.getDegree()) ? " - " : (output.isEmpty() ? "" : " + ");
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
            output.add(sign + term);
        }
        if (output.isEmpty()) {
            return "0";
        } else {
            return String.join("", output);
        }
    }

    public Polynomial(String stringPoly) {

        monomials = new HashMap<>();

        stringPoly = stringPoly.replaceAll("\\s+", "");
        stringPoly = stringPoly.replaceAll("x\\^0", "1");
        String[] terms = stringPoly.split("(?=[+-])");

        for (String term : terms) {
            // parts[0] = coefficient
            // parts[1] = exponent
            String[] parts = term.split("x\\^?"); //x\^?
            for (String part : parts) {
                System.out.println(part);
            }

            Integer exponent;
            Double coef;

            if (term.isEmpty()) {
                continue;
            }

            if (term.equals("x")) {
                monomials.put(1, 1.0);
                continue;
            } else if (term.equals("-x")) {
                monomials.put(1, -1.0);
                continue;
            }

            if (parts.length == 1) {
                if (parts[0].equals("+")) {
                    coef = 1.0;
                    exponent = 0;
                } else {
                    coef = Double.parseDouble(parts[0]);
                    exponent = 0;
                }
                /*coef = Double.parseDouble(parts[0]);
                exponent = 0;*/
            } else if (parts[0].equals("")) {
                coef = 1.0;
                exponent = Integer.parseInt(parts[1]);
            } else if (parts[0].equals("-")) {
                coef = -1.0;
                exponent = Integer.parseInt(parts[1]);
            } else {
                coef = Double.parseDouble(parts[0]);
                exponent = Integer.parseInt(parts[1]);
            }

            if (term.contains("x") && !term.contains("^")) {
                exponent = 1;
            }
            System.out.println("Group: " + coef + " " + exponent + "\n\n");
            monomials.put(exponent, coef);
        }
        System.out.println("Here you go: " + monomials + "\n\n");
    }

    public Map<Integer, Double> getMonomials() {
        return monomials;
    }

    public void setMonomials(Map<Integer, Double> monomials) {
        this.monomials = monomials;
    }
}
