package AdvancedSorting.homework2;

import javax.swing.*;
import java.io.*;

// mergeSort.java
// demonstrates recursive merge sort
// to run this program: C>java MergeSortApp
////////////////////////////////////////////////////////////////
class DArray {
   private long[] theArray; // ref to array theArray
   private int nElems; // number of data items

   //-----------------------------------------------------------
   public DArray(int max) // constructor
   {
      theArray = new long[max]; // create array
      nElems = 0;
   }

   //-----------------------------------------------------------
   public void insert(long value) // put element into array
   {
      if (nElems < theArray.length) {
         theArray[nElems] = value; // insert it
         nElems++; // increment size
      } else {
         System.out.println("Array is full, cannot insert more elements");
      }
   }

   //-----------------------------------------------------------
   public void display() // displays array contents
   {
      for (int j = 0; j < nElems; j++) // for each element,
         System.out.print(theArray[j] + " "); // display it
      System.out.println("");
   }

   //-----------------------------------------------------------
   public void mergeSort() // called by main()
   { // provides workspace
      long[] workSpace = new long[nElems];
      recMergeSort(workSpace, 0, nElems - 1);
   }

   //-----------------------------------------------------------
   private void recMergeSort(long[] workSpace, int lowerBound,
                             int upperBound) {
      if (lowerBound == upperBound) // if range is 1,
         return; // no use sorting
      else { // find midpoint
         int mid = (lowerBound + upperBound) / 2;
         // sort low half
         recMergeSort(workSpace, lowerBound, mid);
         // sort high half
         recMergeSort(workSpace, mid + 1, upperBound);
         // merge them
         merge(workSpace, lowerBound, mid + 1, upperBound);
      } // end else
   } // end recMergeSort()

   //-----------------------------------------------------------
   private void merge(long[] workSpace, int lowPtr,
                      int highPtr, int upperBound) {
      int j = 0; // workspace index
      int lowerBound = lowPtr;
      int mid = highPtr - 1;
      int n = upperBound - lowerBound + 1; // # of items

      while (lowPtr <= mid && highPtr <= upperBound)
         if (theArray[lowPtr] < theArray[highPtr])
            workSpace[j++] = theArray[lowPtr++];
         else
            workSpace[j++] = theArray[highPtr++];

      while (lowPtr <= mid)
         workSpace[j++] = theArray[lowPtr++];

      while (highPtr <= upperBound)
         workSpace[j++] = theArray[highPtr++];

      for (j = 0; j < n; j++) {
         theArray[lowerBound + j] = workSpace[j];
         System.out.print(workSpace[j] + " ");
      }
      System.out.println();
   } // end merge()
   //-----------------------------------------------------------
} // end class DArray

////////////////////////////////////////////////////////////////
class MergeSortApp {
   public static void main(String[] args) throws IOException {
      int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter size:"));
      DArray array = new DArray(size);
      FileReader fr = new FileReader("src/AdvancedSorting/homework2/data.txt");
      BufferedReader reader = new BufferedReader(fr);
      String line;
      int count = 0;
      while ((line = reader.readLine()) != null && count < size) {
         long value = Long.parseLong(line.trim());
         array.insert(value);
         count++;
      }
      reader.close();

      array.display();

      long startTime = System.nanoTime();
      array.mergeSort();
      long endTime = System.nanoTime();

      double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
      System.out.printf("Time taken to sort: %.6f seconds%n", durationInSeconds);


   } // end main()
} // end class MergeSortApp
////////////////////////////////////////////////////////////////
