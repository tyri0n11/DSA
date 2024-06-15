package Graphs;

import java.io.*;

public class GraphDegrees {
    public static void main(String[] args) {
        String inputFileName = "src/Graphs/BacVaoRa_Inp.txt";
        String outputFileName = "src/Graphs/BacVaoRa_Out.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));

            // Read the number of vertices
            String firstLine = br.readLine().trim();
            int n;
            try {
                System.out.println("Reading number of vertices: " + firstLine); // Debugging output
                n = Integer.parseInt(firstLine);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("The first line of the input file must be an integer representing the number of vertices.");
            }

            // Initialize the adjacency matrix
            int[][] adjacencyMatrix = new int[n][n];

            // Read the adjacency matrix from the input file
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null) {
                    throw new IllegalArgumentException("The input file does not contain the correct number of lines for the adjacency matrix.");
                }

                String[] numbers = line.trim().split("\\s+");
                System.out.println("Reading line " + (i + 1) + ": " + line); // Debugging output
                if (numbers.length != n) {
                    throw new IllegalArgumentException("Each line of the adjacency matrix must contain " + n + " integers.");
                }

                for (int j = 0; j < n; j++) {
                    try {
                        adjacencyMatrix[i][j] = Integer.parseInt(numbers[j]);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("The adjacency matrix must contain only integers.");
                    }
                }
            }

            // Calculate the in-degree and out-degree of each vertex
            int[] inDegrees = new int[n];
            int[] outDegrees = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adjacencyMatrix[i][j] == 1) {
                        outDegrees[i]++;
                        inDegrees[j]++;
                    }
                }
            }

            // Write the output
            bw.write(n + "\n");
            for (int i = 0; i < n; i++) {
                bw.write(inDegrees[i] + " " + outDegrees[i] + "\n");
            }

            // Close the readers and writers
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
