package Recursion;

public class KnapsackSolver {
    public static int knapsack(int capacity, int[] weights, int index) {
        // Base case: if either the capacity is 0 or we've reached the end of the items
        if (capacity == 0 || index == weights.length) {
            return 0;
        }

        // If the weight of the current item exceeds the capacity, skip it
        if (weights[index] > capacity) {
            return knapsack(capacity, weights, index + 1);
        }

        // Recursive case:
        // 1. Exclude the current item
        // 2. Include the current item and reduce capacity and index
        int exclude = knapsack(capacity, weights, index + 1);
        int include = weights[index] + knapsack(capacity - weights[index], weights, index + 1);

        // Return the maximum value of including or excluding the current item
        return Math.max(include, exclude);
    }
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5}; // Example weights
        int capacity = 7; // Example knapsack capacity
        int maxValue = knapsack(capacity, weights, 0);
        System.out.println("Maximum value that can be achieved: " + maxValue);
    }
}
