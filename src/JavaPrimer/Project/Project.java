package JavaPrimer.Project;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Project {

    public static void main(String[] args){
        new GraphicalTest();
    }
    // P-1.26 Write a short Java program that takes all the lines input to standard input and
    // writes them to standard output in reverse order. That is, each line is output in the
    // correct order, but the ordering of the lines is reversed.
    public static void reverseLines(){
        Scanner sc = new Scanner(System.in);
        Stack<String> lines = new Stack<>();

        // Read lines from standard input
        while (sc.hasNextLine()) {
            lines.push(sc.nextLine());
        }
            // Ctrl D to end input
        // Print lines in reverse order
        while (!lines.isEmpty()) {
            System.out.println(lines.pop());
        }
        sc.close();
    }
    // P-1.27 Write a Java program that can simulate a simple calculator,using the Java console
    // as the exclusive input and output device. That is, each input to the calculator, be
    // it a number, like 12.34 or 1034, or an operator, like + or =, can be done on a
    // separate line. After each such input, you should output to the Java console what
    // would be displayed on your calculator.
    public static void calculator(){
        Scanner sc = new Scanner(System.in);

        float firstNumber;
        char operator;
        float secondNumber;
        while (true) {
            try {
                System.out.print("Enter a number: ");
                firstNumber = sc.nextFloat();

                System.out.print("Enter an operator (+, -, *, /): ");
                operator = sc.next().charAt(0);  // Read first character only

                System.out.print("Enter 2nd number: ");
                secondNumber = sc.nextFloat();
                break;
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a number followed by an operator (+, -, *, /).");
                sc.nextLine();  // Clear the scanner buffer to avoid infinite loop on invalid input
            }
        }
        sc.close();
        System.out.println(firstNumber +"  "+ operator +"  "+ secondNumber +" = " + calculate(firstNumber,operator,secondNumber));
    }
    public static float calculate(float a,char ope,float b){
        return switch (ope) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0.0F;
        };
    }
    // P-1.28 A common punishment for school children is to write out a sentence multiple
    // times. Write a Java stand-alone program that will write out the following sen
    //tence one hundred times: “I will never spam my friends again.” Your program
    // should number each of the sentences and it should make eight different random
    //looking typos
    public static void solution(){
        String s = "I will never spam my friends again.";
        Random random = new Random();

        for(int i=0; i<=100; i++){
            StringBuilder sb = new StringBuilder(s);
            int typos = 8;
            while (typos>0){
                int index = random.nextInt(sb.length());
                char typoChar = (char)(random.nextInt(26)+'a');
                sb.setCharAt(index, typoChar);
                typos--;
            }
            System.out.println(i+". " + sb);
        }
    }
    // P-1.29 The birthday paradox says that the probability that two people in a room will
    // have the same birthday is more than half, provided n, the number of people in the
    // room, is more than 23. This property is not really a paradox, but many people
    // find it surprising. Design a Java program that can test this paradox by a series
    // of experiments on randomly generated birthdays, which test this paradox for n =
    // 5,10,15,20,...,100
    public static void birthdayParadox(){
        int experiments = 10000; // Number of experiments to run
        int maxPeople = 100; // Maximum number of people to test

        Random random = new Random();
        for (int n = 5; n <= maxPeople; n += 5) {
            int count = 0; // Count of experiments where at least two people share the same birthday
            for (int i = 0; i < experiments; i++) {
                if (hasSharedBirthday(n, random)) {
                    count++;
                }
            }
            double probability = (double) count / experiments;
            System.out.println("For n = " + n + ", Probability: " + probability);
        }
    }
    private static boolean hasSharedBirthday(int n, Random random) {
        boolean[] birthdays = new boolean[365]; // Array to represent possible birthdays
        for (int i = 0; i < n; i++) {
            int day = random.nextInt(365); // Randomly generate a birthday
            if (birthdays[day]) {
                return true; // Found a shared birthday
            }
            birthdays[day] = true;
        }
        return false; // No shared birthday found among n people
    }
}

