package JavaOOP.Reinforcement;
// R-2.7 If we choose an incrementof 128, how manycalls to the nextValue method from
// the ArithmeticProgression class of Section 2.2.3 can we make before we cause a
// long-integer overflow?
public class ArithmeticProgression extends AbstractProgression{
    private final long increment;
    public ArithmeticProgression(long step){
        super(0);
        increment = step;
    }
    @Override
    protected void advance() {
        current+=increment;
    }
    public static void main(String[] args){
        ArithmeticProgression a = new ArithmeticProgression(128);
        // ( ( 2^64 - 1 ) / 128 ) -1
        a.printProgression(1441161881);
    }
}
