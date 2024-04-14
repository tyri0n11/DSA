package JavaOOP.Creativity;
// C-2.26 Use a solution to Exercise C-2.25 to create a new progression class for which
// each value is the square root of the previous value, represented as a Double.
// You should include a default constructor that has 65,536 as the first value and a
// parametric constructor that starts with a specified number as the first value
public class SqrtProgression extends AbstractProgression<Double> {

    public SqrtProgression() {
        super(65536.0); // Default starting value
    }

    public SqrtProgression(Double first) {
        super(first); // Start with a specified number
    }

    @Override
    protected void advance() {
        current = Math.sqrt(current);
    }
}
