package AdvancedSorting.homework2;

// Java implementation of QuickSort

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class ArrayQ {
    private long[] arr;
    private int nElems;

    public ArrayQ(int max) {
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

    public void quickSort() {
        QuickSortt.quickSort(arr, 0, nElems - 1);
    }

    public long[] getArray() {
        return arr;
    }

    public int getSize() {
        return nElems;
    }
}

public class QuickSortt {


    // A utility function to swap two elements
    static void swap(long[] arr, long i, long j)
    {
        long temp = arr[Math.toIntExact(i)];
        arr[Math.toIntExact(i)] = arr[Math.toIntExact(j)];
        arr[Math.toIntExact(j)] = temp;
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    static long partition(long[] arr, long low, long high)
    {
        // Choosing the pivot
        long pivot = arr[Math.toIntExact(high)];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        long i = (low - 1);

        for (long j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[Math.toIntExact(j)] < pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    static void quickSort(long[] arr, long low, long high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            long pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);

        }
    }
    // To print sorted array
    public static void printArr(long[] arr)
    {
        for (long i = 0; i < arr.length; i++) {
            System.out.print(arr[Math.toIntExact(i)] + " ");
        }
    }

    // Driver Code
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter size:"));
        ArrayQ arr = new ArrayQ(size);
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

        arr.display(); // display unsorted array

        long startTime = System.nanoTime();
        arr.quickSort(); // shell sort the array
        long endTime = System.nanoTime();

        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("Time taken to sort: %.6f seconds%n", durationInSeconds);

    }
}
