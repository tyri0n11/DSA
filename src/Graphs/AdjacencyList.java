package Graphs;

import java.io.*;
import java.util.*;

public class AdjacencyList {
    public static void main(String[] args) {
        String inputFileName = "src/Graphs/DanhSachKe_Inp.txt";
        String outputFileName = "src/Graphs/DanhSachKe_Out.txt";

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

            // Initialize the degree array
            int[] degrees = new int[n];

            // Read the adjacency list from the input file
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line != null && !line.trim().isEmpty()) {
                    String[] neighbors = line.trim().split("\\s+");
                    degrees[i] += neighbors.length;  // Count the neighbors for vertex i
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
