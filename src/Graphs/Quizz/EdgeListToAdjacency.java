package Graphs.Quizz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class EdgeListToAdjacency {
    public static void main(String[] args) {
        String inputFilePath = "src/Graphs/Quizz/Canh2DSKe_inp.txt";
        String outputFilePath = "src/Graphs/Quizz/Canh2DSKe_out.txt";

        try {
            // Read the input file
            Scanner scanner = new Scanner(new File(inputFilePath));
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            // Initialize the adjacency list
            List<List<Integer>> adjacencyList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                adjacencyList.add(new ArrayList<>());
            }

            // Read edges and fill the adjacency list
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adjacencyList.get(u - 1).add(v);
                adjacencyList.get(v - 1).add(u);
            }
            scanner.close();

            // Write the output file
            PrintWriter writer = new PrintWriter(new File(outputFilePath));
            writer.println(n);
            for (List<Integer> neighbors : adjacencyList) {
                Collections.sort(neighbors);
                for (int neighbor : neighbors) {
                    writer.print(neighbor + " ");
                }
                writer.println();
            }
            writer.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFilePath);
        }
    }
}
