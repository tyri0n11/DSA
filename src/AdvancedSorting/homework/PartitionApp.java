package AdvancedSorting.homework;// PartitionApp.java
// demonstrates partitioning an array and finding the median
////////////////////////////////////////////////////////////////

class PartitionApp {
   public static void main(String[] args) {
      int maxSize = 16;             // array size
      ArrayPar arr;                 // reference to array
      arr = new ArrayPar(maxSize);  // create the array

      for (int j = 0; j < maxSize; j++) {  // fill array with
         long n = (int) (Math.random() * 199);
         arr.insert(n);
      }
      arr.display();                // display unsorted array

      long median = arr.findMedian();
      System.out.println("Median is " + median);
      arr.display();                // display partitioned array
   }  // end main()
}  // end class PartitionApp
////////////////////////////////////////////////////////////////

class ArrayPar {
   private long[] theArray;          // ref to array theArray
   private int nElems;               // number of data items

   //--------------------------------------------------------------
   public ArrayPar(int max) {         // constructor
      theArray = new long[max];      // create the array
      nElems = 0;                    // no items yet
   }

   //--------------------------------------------------------------
   public void insert(long value) {   // put element into array
      theArray[nElems] = value;      // insert it
      nElems++;                      // increment size
   }

   //--------------------------------------------------------------
   public int size() {                // return number of items
      return nElems;
   }

   //--------------------------------------------------------------
   public void display() {            // displays array contents
      System.out.print("A=");
      for (int j = 0; j < nElems; j++)    // for each element,
         System.out.print(theArray[j] + " ");  // display it
      System.out.println("");
   }

   //--------------------------------------------------------------
   public int partitionIt(int left, int right) {
      long pivot = theArray[right];      // pivot is the rightmost element
      int leftPtr = left - 1;            // right of first elem
      int rightPtr = right;              // left of pivot
      while (true) {
         while (leftPtr < right - 1 &&    // find bigger item
                 theArray[++leftPtr] < pivot)
            ;  // (nop)

         while (rightPtr > left &&        // find smaller item
                 theArray[--rightPtr] > pivot)
            ;  // (nop)
         if (leftPtr >= rightPtr)         // if pointers cross,
            break;                       //    partition done
         else                            // not crossed, so
            swap(leftPtr, rightPtr);     //    swap elements
      }  // end while(true)
      swap(leftPtr, right);              // swap pivot into correct place
      return leftPtr;                    // return partition
   }  // end partitionIt()

   //--------------------------------------------------------------
   public long findMedian() {
      int left = 0;
      int right = nElems - 1;
      int medianIndex = nElems / 2;

      while (true) {
         int pivotIndex = partitionIt(left, right);
         if (pivotIndex == medianIndex) {
            return theArray[pivotIndex];
         } else if (pivotIndex < medianIndex) {
            left = pivotIndex + 1;
         } else {
            right = pivotIndex - 1;
         }
      }
   }

   //--------------------------------------------------------------
   public void swap(int dex1, int dex2) {  // swap two elements
      long temp;
      temp = theArray[dex1];             // A into temp
      theArray[dex1] = theArray[dex2];   // B into A
      theArray[dex2] = temp;             // temp into B
   }  // end swap()
   //--------------------------------------------------------------
}  // end class ArrayPar
////////////////////////////////////////////////////////////////
