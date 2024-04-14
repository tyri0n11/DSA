package JavaOOP.Creativity;

public class Main {

    public static void answer_C_2_16 (){
        // C-2.16 Suppose you are on the design team for a new e-book reader. What are the
        // primary classes and methods that the Java software for your reader will need?
        // You should include an inheritance diagram for this code, but you don’t need to
        // write any actual code. Your software architecture should at least include ways for
        // customers to buy new books, view their list of purchased books, and read their
        // purchased books.

        System.out.println("User Interaction and Management:");
        System.out.println("The 'User' class handles user interactions with the system, including login, logout, registration, and purchasing books.");
        System.out.println();

        System.out.println("Book Management:");
        System.out.println("The 'Library' class acts as a repository for all books available, with methods to add, remove, and search for books.");
        System.out.println("The 'Book' class is the superclass for 'EBook' and 'AudioBook', which add specific features for their formats.");
        System.out.println();

        System.out.println("Reading Interface:");
        System.out.println("The 'Reader' class provides the reading interface, with methods to open and close books, navigate pages, and bookmark them.");
        System.out.println();

        System.out.println("Purchasing Process:");
        System.out.println("The 'ShoppingCart' class manages the cart, and the 'PaymentProcessor' class handles transactions.");
        System.out.println();

        System.out.println("Inheritance Diagram:");
        System.out.println("      Book");
        System.out.println("     /    \\");
        System.out.println("EBook    AudioBook");
        System.out.println();
    }
    public static void answer_C_2_17(){
        //C-2.17 Most modern Java compilers have optimizers that can detect simple cases when
        // it is logically impossible for certain statements in a program to ever be executed.
        // In such cases, the compiler warns the programmer about the useless code. Write
        // a short Java method that contains code for which it is provably impossible for
        // that code to ever be executed, yet the Java compiler does not detect this fact.
        if (alwaysTrue() && alwaysFalse()) {
            System.out.println("This will never be printed!");
        }
    }
    public static boolean alwaysTrue() {
        return true;
    }
    public static boolean alwaysFalse() {
        return false;
    }

    //C-2.21 Write a program that consists of three classes, A, B, and C, such that B extends
    // A and thatC extends B. Each class should define an instance variable named “x”
    // (that is, each has its own variable named x). Describe a way for a method in C
    // to access and set A’s version of x to a given value, without changing B or C’s
    // version.
    class A {
        int x;

        public A(int x) {
            this.x = x;
        }

        // Method to access and set A's x through a protected setter
        protected void setAX(int value) {
            this.x = value;
        }
    }

    class B extends A {
        int y;

        public B(int x, int y) {
            super(x);  // Call A's constructor to initialize its x
            this.y = y;
        }
    }

    public class C extends B {
        int z;

        public C(int x, int y, int z) {
            super(x, y);  // Call B's constructor to initialize its x and y
            this.z = z;
        }

        public void setAXValue(int value) {
            super.setAX(value);  // Call A's protected setAX method through B
        }
    }
    public static void answer_2_22(){
        //C-2.22 Explain why the Java dynamic dispatch algorithm, which looks for the method
        // to invoke for a call obj.foo(), will never get into an infinite loop
        System.out.println("The Java dynamic dispatch algorithm will never get into an infinite loop when calling obj.foo() because of the following reasons:");
        System.out.println("\t1. Finite Inheritance Hierarchy: Java classes have a single inheritance structure, creating a well-defined chain of inheritance.");
        System.out.println("\t2. Ultimate Superclass: All Java classes ultimately inherit from the Object class, serving as the root and providing a stopping point.");
        System.out.println("\t3. Method Resolution at Runtime: The dynamic dispatch algorithm finds the specific method based on the object's actual type at runtime, not the declared type of the reference variable.");
        System.out.println("This combination ensures the search for foo() eventually terminates, either by finding the method or encountering an error.");
    }

    public static void main(String[] args){
        answer_2_22();
    }
}
