package Recursion;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamCombination {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Method to calculate combinations
    public static int combinations(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }
    public static void showTeams(int[] group, int k, ArrayList<Integer> currentTeam, int index) {

        // Base case: if the current team size is k, print the team
        if (currentTeam.size() == k) {
            System.out.println(currentTeam);
            return;
        }

        // Recursive case:
        // Start from the current index and explore all combinations by including or excluding each element
        for (int i = index; i < group.length; i++) {
            // Include the current element in the team
            currentTeam.add(group[i]);
            // Recur for the next index with a reduced team size
            showTeams(group, k, currentTeam, i + 1);
            // Exclude the current element and backtrack
            currentTeam.remove(currentTeam.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the group size
        System.out.print("Enter the group size (n): ");
        int n = scanner.nextInt();
        int[] group = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i + 1;
        }

        // Prompt the user for the team size
        System.out.print("Enter the team size (k): ");
        int k = scanner.nextInt();

        // Call the recursive method to show all possible teams
        System.out.println("All possible teams:");
        showTeams(group, k, new ArrayList<>(), 0);
        int numOfTeams = combinations(n, k);
        System.out.println("Number of possible teams: " + numOfTeams);
        scanner.close();
    }
}
