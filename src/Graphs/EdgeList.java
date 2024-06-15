package Graphs;

import java.io.*;
import java.util.*;

public class EdgeList {
    public static void main(String[] args) {
        String inputFileName = "src/Graphs/DanhSachCanh_Inp.txt";
        String outputFileName = "src/Graphs/DanhSachCanh_Out.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));

            // Read the number of vertices and edges
            String firstLine = br.readLine().trim();
            int n, m;
            try {
                String[] firstLineParts = firstLine.split("\\s+");
                n = Integer.parseInt(firstLineParts[0]);
                m = Integer.parseInt(firstLineParts[1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("The first line of the input file must contain two integers representing the number of vertices and edges.");
            }

            // Initialize the degree array
            int[] degrees = new int[n];

            // Read the edge list from the input file
            for (int i = 0; i < m; i++) {
                String line = br.readLine();
                if (line != null && !line.trim().isEmpty()) {
                    String[] edge = line.trim().split("\\s+");
                    int u, v;
                    try {
                        u = Integer.parseInt(edge[0]) - 1;
                        v = Integer.parseInt(edge[1]) - 1;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Each edge must contain two integers.");
                    }
                    if (u < 0 || u >= n || v < 0 || v >= n) {
                        throw new IllegalArgumentException("Vertex index out of bounds.");
                    }
                    degrees[u]++;
                    degrees[v]++;
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
