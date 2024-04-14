package JavaOOP.Creativity;

public class ArithmeticProgression extends AbstractProgression<Long> {
    private final Long increment;

    public ArithmeticProgression(Long step){
        super(0L);
        increment = step;
    }

    @Override
    protected void advance() {
        current += increment;
    }

    public static void main(String[] args){
        ArithmeticProgression a = new ArithmeticProgression(128L);
        // ( ( 2^64 - 1 ) / 128 ) -1
        a.printProgression(1441161881);
    }
}
