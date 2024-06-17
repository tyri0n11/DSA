package Graphs.Quizz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyToEdgeList {
    public static void main(String[] args) throws FileNotFoundException {
        String input = "src/Graphs/Quizz/DSKe2Canh_inp.txt";
        String out = "src/Graphs/Quizz/DSKe2Canh_out.txt";

        Scanner sc = new Scanner(new File(input));
        int vertices = sc.nextInt();
        sc.nextLine();

        List<List<Integer>> adjacencyList = new ArrayList<>(vertices);

        for(int i=0; i< vertices; i++){
            adjacencyList.add(new ArrayList<>());
            String[] split = sc.nextLine().split(" ");
            for(String integer : split){
                adjacencyList.get(i).add(Integer.parseInt(integer));
            }
        }
        sc.close();

        //edge list
        List<int[]> edgeList = new ArrayList<>();
        for (int ver = 0; ver<vertices; ver++){
            for (int ed : adjacencyList.get(ver)){
                if(ver<ed-1){
                    edgeList.add(new int[]{ver+1,ed});
                }
            }
        }



    }
}
