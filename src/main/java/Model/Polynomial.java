import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    public Map<Integer, Monomial> poly;

    public Polynomial() {
        poly = new HashMap<>();
    }

    public Polynomial(Map<Integer, Monomial> poly) {
        this.poly = poly;
    }

    public Integer getDegree() {
        return poly.keySet().stream().max(Integer::compareTo).orElse(0);
    }

    public Polynomial(String stringPoly) {

        /*
        Polynomial polyOut = new Polynomial();
        String[] terms = stringPoly.split("([+-]?[^-+]+)");

        for (int i = 0; i < terms.length; i++) {
            String term = terms[i];

            String[] parts = term.split("x\\^");

            if (parts.length == 2) {
                polyOut.poly.put(
                        Integer.parseInt(parts[1]),
                        new Monomial(
                                Integer.parseInt(parts[1]),
                                Integer.parseInt(parts[0])
                        )
                );
            } else if (term.contains("x")) {
                polyOut.poly.put(
                        Integer.parseInt(parts[0]),
                        new Monomial(
                                Integer.parseInt(parts[0]),
                                1
                        )
                );
            } else {
                polyOut.poly.put(
                        Integer.parseInt(parts[0]),
                        new Monomial(
                                Integer.parseInt(parts[0]),
                                0
                        )
                );
            }
        }
        */

        poly = new HashMap<>();
        String[] terms = stringPoly.split("([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");

        for (String term : terms) {
            String[] parts = term.split("x\\^");

            if (parts.length == 2) {
                poly.put(
                        Integer.parseInt(parts[1]),
                        new Monomial(
                                Integer.parseInt(parts[1]),
                                Integer.parseInt(parts[0])
                        )
                );
            } else if (term.contains("x")) {
                poly.put(
                        1,
                        new Monomial(
                                1,
                                Integer.parseInt(parts[0])
                        )
                );
            } else {
                poly.put(
                        0,
                        new Monomial(
                                0,
                                Integer.parseInt(parts[0])
                        )
                );
            }
        }
    }
}
