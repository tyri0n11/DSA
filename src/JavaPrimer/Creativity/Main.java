package JavaPrimer.Creativity;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        float[] a = {0.515F,44.315F,3.515F,5.626F, 5.636F};
        method2(a);

    }
    // C-1.14 Write a pseudocode description of a method that reverses an array of n integers,
    // so that the numbers are listed in the opposite order than they were before, and
    // compare this method to an equivalent Java method for doing the same thing.
    public static void describeC1_14(){
        System.out.printf("Initialize variables for indices \n" +
                "Iterate until start index is less than end index \n" +
                "Swap elements at start and end indices \n"+
                "Move start index forward and end index backward\n");
    }
    // C-1.15 Write a pseudocode description of a method for finding the smallest and largest
    // numbers in an array of integers and compare that to a Java method that would do
    // the same thing.
    public static void describeC1_15(){
        System.out.printf("The pseudocode describes a method to reverse an array of integers by swapping elements from \n" +
                "the start and end of the array until the start index is less than the end index. This method is quite \n" +
                "similar to an equivalent Java method for reversing an array, which typically uses a similar approach \n"+
                "with a loop to traverse the array from both ends and swap elements until the entire array is reversed.");
    }
    // C-1.16 Write a short program that takes as input three integers, a, b, and c, from the Java
    // console and determines if they can be used in a correct arithmetic formula (in the
    // given order), like “a+b = c,” “a = b−c,” or “a∗b= c.”
    public static void program1(int a, int b, int c){
        if( a+b==c ){
            System.out.printf("%d + %d = &d", a, b, c);
        }if( a==b-c ){
            System.out.printf("%d = %d - &d", a, b, c);
        }if( a*b==c ){
            System.out.printf("%d * %d = &d", a, b, c);
        }else System.out.println("Cannot form a correct arithmetic formula with the given integers.");
    }

    //C-1.17 Write a short Java method that takes an array of int values and determines if there
    // is a pair of distinct elements of the array whose product is even.
    public static void method1(){
        int[] arr = {1,3,5,7,9,2};
        for(int i=0; i<arr.length; i++){
            for(int k=i+1; k<arr.length; k++){
                if((i*k)%2==0){
                    System.out.println(arr[i] +" * " + arr[k] + " is even");
                }else System.out.println(arr[i] +" * " + arr[k] + " is odd");
            }
        }
    }
    //C-1.18
    public static double calculateNorm(double[] vector, int p) {
        double result = 0.0;

        if (p == 2) {
            // Calculate Euclidean norm
            double sumOfSquares = 0;
            for (double coordinate : vector) {
                sumOfSquares += coordinate * coordinate;
            }
            result = Math.sqrt(sumOfSquares);
        } else if (p == Integer.MAX_VALUE) {
            // Calculate Chebyshev norm
            result = Arrays.stream(vector).map(Math::abs).max().getAsDouble();
        } else {
            // Calculate general p-norm
            double sumOfPowers = 0;
            for (double coordinate : vector) {
                sumOfPowers += Math.pow(Math.abs(coordinate), p);
            }
            result = Math.pow(sumOfPowers, 1.0 / p);
        }

        return result;
    }
    //C-1.19 Write a Java program that can take a positive integer greater than 2 as input and
    // write out the number of times one must repeatedly divide this number by 2 before
    // getting a value less than 2
    public static void program2(){

        Scanner sc = new Scanner(System.in);
            System.out.println("enter a number greater than 2: ");
            double n = sc.nextDouble();
            sc.close();
        if(n>2){
            for (double nail = n; nail>=2; nail/=2){
                System.out.println(nail);
            }
        }else System.out.println("nothing happens");
    }

    //C-1.20 Write a Java method that takes an array of float values and determines if all the
    // numbers are different from each other (that is, they are distinct).
    public static boolean method2 (float[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    //C-1.21 Write a Java method that takes an array containing the set of all integers in the
    // range 1 to 52 and shuffles it into random order. Your method should output each
    // possible order with equal probability.
    public static void method3(int [] arr){
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // Generate a random index between 0 and i (inclusive)
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    //C-1.22 Write a short Java program that outputs all possible strings formed by using the
    // characters 'c', 'a', 't', 'd', 'o', and 'g' exactly once.
    public static void method4(){
        char[] chars = {'c', 'a', 't', 'd', 'o', 'g'};

        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                swap(chars, i, j);
                swap(chars, i, j); // Backtrack by swapping back
            }
        }
    }
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    //C-1.23 Write a short Java program that takes two arrays a and b of length n storing int
    // values, and returns the dot product of a and b. That is, it returns an array c of
    // length n such that c[i] = a[i]·b[i], for i = 0,...,n−1.
    public static int[] method5(int[] a, int[] b){
        //Assume a and b have same length
        int[] c = Arrays.copyOf(a, a.length);
        for(int i=0; i<c.length; i++){
            c[i] = a[i]*b[i];
        }
        return c;
    }
    //C-1.24 Modify the CreditCard class from Code Fragment 1.5 so that printSummary be
    //comes a nonstatic method, and modify the main method fromCode Fragment1.6
    // accordingly.

    //C-1.25 Modify the CreditCard class to add a toString() method that returns a String
    // representation of the card (rather than printing it to the console, as done by
    // printSummary). Modify the main method from Code Fragment 1.6 accordingly
    // to use the standard println command.
    
}

