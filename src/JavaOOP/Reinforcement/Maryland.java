package JavaOOP.Reinforcement;
// R-2.11 Consider the following code fragment, taken from some package
// What is the output from calling the main() method of the Maryland class?
public class Maryland extends State {
    Maryland() {}
        public void printMe() {
            System.out.println("Read it.");
    }
    public static void main(String[] args){
            Region east = new State();
            State md = new Maryland();
            Object obj = new Place();
            Place usa = new Region();
            md.printMe();

            east.printMe();

            ((Place) obj).printMe();
            obj = md;

            ((Maryland) obj).printMe();
            obj = usa;
            ((Place) obj).printMe();
            usa = md;
            ((Place) usa).printMe();
        }
    }

