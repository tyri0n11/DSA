package AdvancedSorting.homework;
import java.util.*;

public class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjList; // Adjacency List

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge into the graph
    public void addEdge(int v, int w) {
        adjList[v].add(w); // Add w to v's list.
    }

    // Method to print BFS traversal from a given source node
    public void BFS(int source) {
        boolean[] visited = new boolean[vertices];
        int[] layer = new int[vertices];

        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the source node as visited and enqueue it
        visited[source] = true;
        queue.add(source);
        layer[source] = 0;

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue
            int node = queue.poll();
            int nodeLayer = layer[node];

            // Process each adjacent node
            for (int adj : adjList[node]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                    layer[adj] = nodeLayer + 1;
                }
            }
        }

        // Print nodes at each layer
        Map<Integer, List<Integer>> layerMap = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            int currentLayer = layer[i];
            if (!layerMap.containsKey(currentLayer)) {
                layerMap.put(currentLayer, new ArrayList<>());
            }
            layerMap.get(currentLayer).add(i);
        }

        for (int i = 0; i < layerMap.size(); i++) {
            System.out.println("Layer " + i + ": " + layerMap.get(i));
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);

        // Construct the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 6);
        g.addEdge(3, 7);

        System.out.println("Nodes at each layer:");
        g.BFS(0); // Start BFS from node 0
    }
}
