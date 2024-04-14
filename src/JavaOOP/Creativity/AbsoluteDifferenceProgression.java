package JavaOOP.Creativity;

public class AbsoluteDifferenceProgression extends AbstractProgression<Long> {

    protected Long prev;

    public AbsoluteDifferenceProgression() {
        this(2L, 200L); // Default starting values
    }

    public AbsoluteDifferenceProgression(Long first, Long second) {
        super(first); // Call superclass constructor with first value
        prev = second; // Initialize prev with second value
    }

    protected void advance() {
        Long diff = Math.abs(current - prev); // Calculate absolute difference
        prev = current; // Update prev with current value
        current = diff; // Update current with the calculated difference
    }

}
