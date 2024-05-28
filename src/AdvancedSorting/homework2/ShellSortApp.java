package AdvancedSorting.homework2;

import javax.swing.*;
import java.io.*;

// shellSort.java
// demonstrates shell sort
// to run this program: C>java ShellSortApp
//--------------------------------------------------------------
class ArraySh {
    private long[] theArray; // ref to array theArray
    private int nElems; // number of data items

    // --------------------------------------------------------------
    public ArraySh(int max) // constructor
    {
        theArray = new long[max]; // create the array
        nElems = 0; // no items yet
    }

    // --------------------------------------------------------------
    public void insert(long value) // put element into array
    {
        if (nElems < theArray.length) {
            theArray[nElems] = value; // insert it
            nElems++; // increment size
        } else {
            System.out.println("Array is full, cannot insert more elements");
        }
    }

    // --------------------------------------------------------------
    public void display() // displays array contents
    {
        System.out.print("A=");
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(theArray[j] + " "); // display it
        System.out.println("");
    }

    // --------------------------------------------------------------
    public void shellSort() {
        int inner, outer;
        long temp;
        int h = 1; // find initial value of h
        while (h <= nElems / 3)
            h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)
        while (h > 0) // decreasing h, until h=1
        {
            // h-sort the file
            for (outer = h; outer < nElems; outer++) {
                temp = theArray[outer];
                inner = outer;
                // one subpass (e.g., 0, 4, 8)
                while (inner > h - 1 && theArray[inner - h] >= temp) {
                    theArray[inner] = theArray[inner - h];
                    inner -= h;
                }
                theArray[inner] = temp;
            } // end for
            h = (h - 1) / 3; // decrease h
        } // end while(h>0)
    } // end shellSort()
    // --------------------------------------------------------------
} // end class ArraySh
//////////////////////////////////////////////////////////////

class ShellSortApp {
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter size:"));
        ArraySh arr = new ArraySh(size);
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
        arr.shellSort(); // shell sort the array
        long endTime = System.nanoTime();

        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("Time taken to sort: %.6f seconds%n", durationInSeconds);
    } // end main()
} // end class ShellSortApp
