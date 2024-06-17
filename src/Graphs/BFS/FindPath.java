package Graphs.BFS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class FindPath {
    public static void main(String[] args) throws FileNotFoundException {
        String input = "src/Graphs/BFS/FindPath_in";
        String output = "src/Graphs/BFS/FindPath_out";
        Scanner sc = new Scanner(new File(input));
        int vertices = sc.nextInt();
        int start = sc.nextInt() - 1;
        int end = sc.nextInt() - 1;
        sc.nextLine();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            ArrayList<Integer> vertex = new ArrayList<>();
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                vertex.add(Integer.parseInt(line[j]) - 1);
            }
            graph.add(vertex);
        }

        ArrayList<Integer> path = bfs(graph, start, end);

        writeOutput(output, path);
    }

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> graph, int start, int goal) {
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        Set<Integer> explored = new HashSet<>();
        queue.add(new ArrayList<>(Arrays.asList(start)));

        while (!queue.isEmpty()) {
            ArrayList<Integer> path = queue.poll();
            int node = path.get(path.size() - 1);

            if (node == goal) {
                // Convert path to 1-based indexing
                for (int i = 0; i < path.size(); i++) {
                    path.set(i, path.get(i) + 1);
                }
                return path;
            }

            if (!explored.contains(node)) {
                explored.add(node);

                for (int neighbor : graph.get(node)) {
                    ArrayList<Integer> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }

        return new ArrayList<>();
    }

    public static void writeOutput(String filename, ArrayList<Integer> path) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(filename));
        pw.println(path.size());
        for (int node : path) {
            pw.print(node + " ");
        }
        pw.println();
        pw.close();
    }
}
