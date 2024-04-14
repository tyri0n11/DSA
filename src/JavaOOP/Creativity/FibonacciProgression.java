package JavaOOP.Creativity;

import java.math.BigInteger;

//C-2.27 Use a solution to Exercise C-2.25 to reimplement the FibonacciProgression sub
//class to rely on the BigInteger class, in order to avoid overflows all together.
public class FibonacciProgression extends AbstractProgression<BigInteger> {
    protected BigInteger prev;

    public FibonacciProgression() {
        this(BigInteger.valueOf(2), BigInteger.valueOf(2));
    }

    public FibonacciProgression(BigInteger first, BigInteger second) {
        super(first);
        prev = second.subtract(first); // fictitious value preceding the first
    }

    protected void advance() {
        BigInteger temp = current;
        current = current.add(prev);  // Combine calculations without temporary variable
        prev = temp;  // Update prev using current and previous prev
    }
}
