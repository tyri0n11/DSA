package JavaOOP.Creativity;

//C-2.25 Redesign the Progression class to be abstract and generic, producing a sequence
// of values of generic type T, and supporting a single constructor that accepts an
// initial value. Make all corresponding modifications to the rest of the classes in
// our hierarchy so that they remain as non-generic classes, while inheriting from the
// new generic Progression class.
public abstract class AbstractProgression<L extends  Number> {
    protected L current;

    public AbstractProgression() {
        this(null);
    }

    public AbstractProgression(L value) {
        current = value;
    }

    public L nextValue() {
        L answer = current;
        advance(); // this protected call is responsible for advancing the current value
        return answer;
    }

    public void printProgression(int n) {
        System.out.print(nextValue()); // print first value without leading space
        for (int j = 1; j < n; j++) {
            System.out.print(" " + nextValue()); // print leading space before others
        }
        System.out.println(); // end the line
    }

    protected abstract void advance(); // notice the lack of a method body
}
