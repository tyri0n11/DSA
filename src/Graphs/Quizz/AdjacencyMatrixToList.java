package Graphs.Quizz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjacencyMatrixToList {
    public static void main(String[] args) throws FileNotFoundException {
        String input = "src/Graphs/Quizz/Matrix_Inp.txt";
        String out = "src/Graphs/Quizz/Matrix_Out.txt";

        Scanner sc = new Scanner(new File(input));
        int vertices = sc.nextInt();
        sc.nextLine();
        ArrayList<LinkedList<Integer>> adjacencyMatrix = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < vertices; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split("  ");
            LinkedList<Integer> index = new LinkedList<>();
            for (int j = 0; j < tokens.length; j++) {
                index.add(Integer.parseInt(tokens[j]));
            }
            adjacencyMatrix.add(index);
        }

        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        for(LinkedList<Integer> vertice : adjacencyMatrix){
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < vertice.size(); i++) {
                if (vertice.get(i) == 1) {
                    temp.add(i+1);
                }
            }
            result.add(temp);
        }
        System.out.println(result);

        PrintWriter writer = new PrintWriter(new File(out));
        writer.println(result.size());
        for (LinkedList<Integer> temp : result) {
            for (Integer i : temp) {
                writer.print(i + " ");
            }
            writer.println();
        }
        writer.close();

    }
}
