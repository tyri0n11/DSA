package AdvancedSorting.homework;

import java.util.LinkedList;
import java.util.Queue;

class RadixSortApp {
    public static void main(String[] args) {
        int[] data = {421, 240, 35, 532, 305, 430, 124};
        int radix = 10;  // Base 10 for simplicity, can be changed to another base if needed

        System.out.println("Original array:");
        display(data);

        radixSort(data, radix);

        System.out.println("Sorted array:");
        display(data);
    }

    // Function to perform radix sort
    public static void radixSort(int[] array, int radix) {
        int max = getMax(array);  // Get the maximum number to determine the number of digits
        int numDigits = getNumDigits(max, radix);

        @SuppressWarnings("unchecked")
        Queue<Integer>[] buckets = new LinkedList[radix];
        for (int i = 0; i < radix; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int digit = 0; digit < numDigits; digit++) {
            for (int number : array) {
                int bucketIndex = getDigit(number, digit, radix);
                buckets[bucketIndex].add(number);
            }

            int index = 0;
            for (Queue<Integer> bucket : buckets) {
                while (!bucket.isEmpty()) {
                    array[index++] = bucket.remove();
                }
            }
        }
    }

    // Function to get the maximum number in the array
    private static int getMax(int[] array) {
        int max = array[0];
        for (int number : array) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    // Function to get the number of digits in the maximum number (base-radix)
    private static int getNumDigits(int number, int radix) {
        return (int) Math.ceil(Math.log(number + 1) / Math.log(radix));
    }

    // Function to get the digit at the specified position (base-radix)
    private static int getDigit(int number, int digit, int radix) {
        return (number / (int) Math.pow(radix, digit)) % radix;
    }

    // Function to display the array
    public static void display(int[] array) {
        for (int number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
