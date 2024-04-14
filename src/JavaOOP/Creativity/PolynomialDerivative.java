package JavaOOP.Creativity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// C-2.29 Write a Java programthat inputs a polynomialin standard algebraic notation and
// outputs the first derivative of that polynomial
public class PolynomialDerivative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the highest degree of the polynomial:");
        int degree = scanner.nextInt();

        // Input the polynomial
        HashMap<Integer, Double> polynomial = new HashMap<>();
        System.out.println("Enter the coefficients starting from x^0:");
        for (int i = 0; i <= degree; i++) {
            polynomial.put(i, scanner.nextDouble());
        }

        // Calculate the derivative
        HashMap<Integer, Double> derivative = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : polynomial.entrySet()) {
            if (entry.getKey() != 0) {
                derivative.put(entry.getKey() - 1, entry.getKey() * entry.getValue());
            }
        }

        // Print the derivative
        System.out.println("The derivative of the polynomial is:");
        for (Map.Entry<Integer, Double> entry : derivative.entrySet()) {
            System.out.println("Coefficient of x^" + entry.getKey() + " : " + entry.getValue());
        }
    }
}
