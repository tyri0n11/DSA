package AdvancedSorting.homework;// QuickSort2App.java
// demonstrates quick sort with median-of-three partitioning
////////////////////////////////////////////////////////////////
// Exercises:
// 1. Add counters for the number of comparisons, swaps, and recursive calls,
//    and display them after sorting
// 2. Compute the average number of comparisons, swaps, and recursive calls
//    over 100 runs
// 3. Analyze the complexity of the algorithm by varying the size of the
//    array (e.g. 16, 32, 64, 128, 256) and examining the parameters from item 2.


public class QuickSort2App {
   public static void main(String[] args) {
      int maxSize = 16;             // array size
      ArrayIns2 arr;                 // reference to array
      arr = new ArrayIns2(maxSize);  // create the array

      for (int j = 0; j < maxSize; j++) {  // fill array with
         long n = (int) (Math.random() * 99);
         arr.insert(n);
      }
      arr.display();                // display items
      arr.quickSort();              // quicksort them
      arr.display();                // display them again

      // Display counters
      System.out.println("Comparisons: " + arr.getComparisons());
      System.out.println("Swaps: " + arr.getSwaps());
      System.out.println("Recursive calls: " + arr.getRecursiveCalls());

      // Find and display the kth smallest element
      int k = 7; // Change this to the desired k value
      long kthSmallest = arr.selectKthSmallest(k - 1); // k - 1 because of zero-based indexing
      System.out.println("The " + k + "th smallest element is: " + kthSmallest);
   }  // end main()
}  // end class QuickSort2App

////////////////////////////////////////////////////////////////


class ArrayIns2 {
   private long[] theArray;          // ref to array theArray
   private int nElems;               // number of data items
   private long comparisons;
   private long swaps;
   private long recursiveCalls;

   //--------------------------------------------------------------
   public ArrayIns2(int max) {        // constructor
      theArray = new long[max];      // create the array
      nElems = 0;                    // no items yet
      comparisons = 0;
      swaps = 0;
      recursiveCalls = 0;
   }

   //--------------------------------------------------------------
   public void insert(long value) {   // put element into array
      theArray[nElems] = value;      // insert it
      nElems++;                      // increment size
   }

   //--------------------------------------------------------------
   public void display() {            // displays array contents
      System.out.print("A=");
      for (int j = 0; j < nElems; j++)    // for each element,
         System.out.print(theArray[j] + " ");  // display it
      System.out.println("");
   }

   //--------------------------------------------------------------
   public void quickSort() {
      recQuickSort(0, nElems - 1);
   }

   //--------------------------------------------------------------
   public void recQuickSort(int left, int right) {
      recursiveCalls++;
      int size = right - left + 1;
      if (size <= 3)                  // manual sort if small
         manualSort(left, right);
      else {                          // quicksort if large
         long median = medianOf3(left, right);
         int partition = partitionIt(left, right, median);
         recQuickSort(left, partition - 1);
         recQuickSort(partition + 1, right);
      }
   }  // end recQuickSort()

   //--------------------------------------------------------------
   public long medianOf3(int left, int right) {
      int center = (left + right) / 2;
      comparisons++; // For comparing left and center
      if (theArray[left] > theArray[center])
         swap(left, center);
      comparisons++; // For comparing left and right
      if (theArray[left] > theArray[right])
         swap(left, right);
      comparisons++; // For comparing center and right
      if (theArray[center] > theArray[right])
         swap(center, right);

      swap(center, right - 1);             // put pivot on right
      return theArray[right - 1];          // return median value
   }  // end medianOf3()

   //--------------------------------------------------------------
   public void swap(int dex1, int dex2) {  // swap two elements
      swaps += 3;  // Each swap counts as three copies
      long temp = theArray[dex1];        // A into temp
      theArray[dex1] = theArray[dex2];   // B into A
      theArray[dex2] = temp;             // temp into B
   }

   //--------------------------------------------------------------
   public int partitionIt(int left, int right, long pivot) {
      int leftPtr = left;             // right of first elem
      int rightPtr = right - 1;       // left of pivot

      while (true) {
         while (theArray[++leftPtr] < pivot)  // find bigger
            comparisons++;                   //    comparison
         comparisons++;  // For the final comparison when while fails

         while (theArray[--rightPtr] > pivot) // find smaller
            comparisons++;                   //    comparison
         comparisons++;  // For the final comparison when while fails

         if (leftPtr >= rightPtr)      // if pointers cross,
            break;                    //    partition done
         else                         // not crossed, so
            swap(leftPtr, rightPtr);  // swap elements
      }  // end while(true)
      swap(leftPtr, right - 1);         // restore pivot
      return leftPtr;                 // return pivot location
   }  // end partitionIt()

   //--------------------------------------------------------------
   public void manualSort(int left, int right) {
      int size = right - left + 1;
      if (size <= 1)
         return;         // no sort necessary
      if (size == 2) {               // 2-sort left and right
         comparisons++; // For comparing left and right
         if (theArray[left] > theArray[right])
            swap(left, right);
         return;
      } else {               // size is 3
         comparisons++; // For comparing left and right-1
         if (theArray[left] > theArray[right - 1])
            swap(left, right - 1);                // left, center
         comparisons++; // For comparing left and right
         if (theArray[left] > theArray[right])
            swap(left, right);                  // left, right
         comparisons++; // For comparing right-1 and right
         if (theArray[right - 1] > theArray[right])
            swap(right - 1, right);               // center, right
      }
   }  // end manualSort()

   //--------------------------------------------------------------
   public long selectKthSmallest(int k) {
      int left = 0;
      int right = nElems - 1;

      while (true) {
         int pivotIndex = partitionIt(left, right, theArray[right]);
         if (pivotIndex == k) {
            return theArray[pivotIndex];
         } else if (pivotIndex < k) {
            left = pivotIndex + 1;
         } else {
            right = pivotIndex - 1;
         }
      }
   }

   // Getter methods for counters
   public long getComparisons() {
      return comparisons;
   }

   public long getSwaps() {
      return swaps;
   }

   public long getRecursiveCalls() {
      return recursiveCalls;
   }
}  // end class ArrayIns2
////////////////////////////////////////////////////////////////
