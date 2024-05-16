package Recursion;

public class Multiplication {

    public static int multiply(int a, int b){
        if (b == 0) {
            return 0; // Base case: anything multiplied by 0 is 0
        } else if (b > 0) {
            return a + multiply(a, b - 1); // Recursive case: a + a + a + ... (b times)
        } else {
            return -multiply(a, -b); // Handle negative b by negating the result
        }
    }
    public static void main(String[] args){
        System.out.println(multiply(2,2));
    }
}
