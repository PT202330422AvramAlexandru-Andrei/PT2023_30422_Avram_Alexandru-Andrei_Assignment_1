import java.util.Map;

public class PolynomialController {
    Polynomial polynomial1, polynomial2;

    public Polynomial addPolynomials(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry : polynomial1.poly.entrySet()) {
            if (polynomial2.poly.containsKey(entry.getKey())) {
                result.poly.put(
                        entry.getKey(),
                        new Monomial(
                                entry.getKey(),
                                entry.getValue().getCoefficient() + polynomial2.poly.get(entry.getKey()).getCoefficient()
                        )
                );
            } else {
                result.poly.put(
                        entry.getKey(),
                        new Monomial(
                                entry.getKey(),
                                entry.getValue().getCoefficient()
                        )
                );
            }
        }

        return result;
    }
}
