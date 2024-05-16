package Midterm;

public class SelectionSort {
    public static void main(String[] args){
        int[] a = {2,8,5,3,9,4,1};
        for(int i =0; i < a.length-1; i++){
            int minIndex = i;
            for (int j=i+1; j<a.length; j++){
                if(a[j]< a[minIndex]){
                    minIndex = j;
                }
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }
        for (int i: a){
            System.out.print(i + ", ");
        }
    }
}
