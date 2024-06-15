package Graphs;

import java.io.*;


public class Graph {
    public static void main(String[] args) {
        String inputFileName = "src/Graphs/data.txt";
        String outputFileName = "src/Graphs/out.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));

            // Read the number of vertices
            String firstLine = br.readLine().trim();
            int n;
            try {
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

            // Calculate the degree of each vertex
            int[] degrees = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    degrees[i] += adjacencyMatrix[i][j];
                }
            }

            // Write the output
            bw.write(n + "\n");
            for (int i = 0; i < n; i++) {
                bw.write(degrees[i] + (i == n - 1 ? "" : " "));
            }

            // Close the readers and writers
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


