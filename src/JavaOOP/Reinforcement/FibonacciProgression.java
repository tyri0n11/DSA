package JavaOOP.Reinforcement;
//R-2.6 Give a short fragment of Java code that uses the progression classes from Sec
//tion 2.2.3 to find the eighth value of a Fibonacci progression that starts with 2
// and 2 as its first two values.
public class FibonacciProgression extends AbstractProgression{
    protected long prev;

    public FibonacciProgression() {
        this(2, 2);
    }

    public FibonacciProgression(long first, long second) {
        super(first);
        prev = second - first; // fictitious value preceding the first
    }

    protected void advance() {
        long temp = prev;
        prev = current;
        current += temp;
    }
}
