package Graphs.BFS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BreadthFirstSearch {
    public static void main(String[] args) throws FileNotFoundException {
        String input = "src/Graphs/BFS/BFS_Inp.txt";
        String output = "src/Graphs/BFS/BFS_Out.txt";
        Scanner sc = new Scanner(new File(input));
        int num = sc.nextInt();
        int vertex = sc.nextInt();
        sc.nextLine();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<num; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            String line = sc.nextLine();
            if(!line.isEmpty()){
                String[] split = line.split(" ");

                for(String integer : split){
                    temp.add(Integer.parseInt(integer));
                }
            }
            list.add(temp);

        }
        System.out.println(list);
        ArrayList<Integer> result = list.get(vertex-1);
        for(ArrayList<Integer> temp : list){
            if (temp == result){
                continue;
            }else{
                for(Integer sth : temp){
                    if (sth == vertex){
                        result.add(list.indexOf(temp));
                    }
                }
            }
            result.remove((Integer) vertex);
        }

        System.out.println(result);
        PrintWriter writer = new PrintWriter(new File(output));
        writer.println(result.size());
        for (Integer ele : result) {
            writer.print(ele + " ");
        }
        writer.close();

    }
}
