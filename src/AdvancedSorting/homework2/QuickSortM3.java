package AdvancedSorting.homework2;

import javax.swing.*;
import java.io.*;

class ArrayQ2 {
    private long[] arr;
    private int nElems;

    public ArrayQ2(int max) {
        arr = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        if (nElems < arr.length) {
            arr[nElems] = value;
            nElems++;
        } else {
            System.out.println("Array is full, cannot insert more elements");
        }
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void quickSortM3() {
        QuickSortM3.quickSort(arr, 0, nElems - 1);
    }

    public void quickSortM3Descending() {
        QuickSortM3.quickSortDescending(arr, 0, nElems - 1);
    }

    public long[] getArray() {
        return arr;
    }

    public int getSize() {
        return nElems;
    }
}

public class QuickSortM3 {

    // A utility function to swap two elements
    static void swap(long[] arr, long i, long j) {
        long temp = arr[Math.toIntExact(i)];
        arr[Math.toIntExact(i)] = arr[Math.toIntExact(j)];
        arr[Math.toIntExact(j)] = temp;
    }

    // Method to find median of three and use it as pivot
    static long medianOfThree(long[] arr, long low, long high) {
        long mid = (low + high) / 2;
        if (arr[Math.toIntExact(low)] > arr[Math.toIntExact(mid)]) {
            swap(arr, low, mid);
        }
        if (arr[Math.toIntExact(low)] > arr[Math.toIntExact(high)]) {
            swap(arr, low, high);
        }
        if (arr[Math.toIntExact(mid)] > arr[Math.toIntExact(high)]) {
            swap(arr, mid, high);
        }
        swap(arr, mid, high - 1);
        return arr[Math.toIntExact(high - 1)];
    }

    // This function takes pivot using median-of-three, places it at correct position
    static long partition(long[] arr, long low, long high) {
        long pivot = medianOfThree(arr, low, high);
        long i = low;
        long j = high - 1;

        while (true) {
            while (arr[Math.toIntExact(++i)] < pivot) ;
            while (arr[Math.toIntExact(--j)] > pivot) ;
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, i, high - 1);
        return i;
    }

    // This function takes pivot using median-of-three, places it at correct position for descending order
    static long partitionDescending(long[] arr, long low, long high) {
        long pivot = medianOfThree(arr, low, high);
        long i = low;
        long j = high - 1;

        for (; i < j; i++, j--) {
            while (arr[Math.toIntExact(i)] > pivot) ;
            while (arr[Math.toIntExact(j)] < pivot) ;
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, i, high - 1);
        return i;
    }



    // The main function that implements QuickSort with median-of-three
    static void quickSort(long[] arr, long low, long high) {
        if (low < high) {
            long pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // The main function that implements QuickSort with median-of-three for descending order
    static void quickSortDescending(long[] arr, long low, long high) {
        if (low < high) {
            long pi = partitionDescending(arr, low, high);
            quickSortDescending(arr, low, pi - 1);
            quickSortDescending(arr, pi + 1, high);
        }
    }

    // Driver Code
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter size:"));
        ArrayQ2 arr = new ArrayQ2(size);

        FileReader fr = new FileReader("src/AdvancedSorting/homework2/data.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line;
        int count = 0;
        while ((line = reader.readLine()) != null && count < size) {
            long value = Long.parseLong(line.trim());
            arr.insert(value);
            count++;
        }
        reader.close();


        long startTime = System.nanoTime();
        arr.quickSortM3Descending(); // quick sort the array in descending order
        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;


        System.out.printf("Time taken to sort in ascending order: %.6f seconds%n", durationInSeconds);



    }
}
