package Midterm;

public class BubbleSort {
    public static void main(String[] args){
        int[] a = {2,8,5,3,9,4,1};
        for(int i =0; i < a.length; i++){
            for (int j=i+1; j<a.length; j++){
                if(a[i]>a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i: a){
            System.out.print(i + ", ");
        }
    }
}
