package SimpleSorting;

// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArrayIns(int max)          // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
public void insertionSort() {
   int in, out;
   int comparisons = 0;
   int copies = 0;

   for (out = 1; out < nElems; out++) { // out is dividing line
      long temp = a[out]; // remove marked item
      in = out; // start shifts at out

      while (in > 0) { // until one is smaller,
         comparisons++; // increment comparison counter
         if (a[in - 1] >= temp) {
            a[in] = a[in - 1]; // shift item to right
            copies++; // increment copy counter
         } else {
            break; // break the loop if condition is not met
         }
         in--; // go left one position
      }
      a[in] = temp; // insert marked item
   } // end for

   System.out.println("Total comparisons: " + comparisons);
   System.out.println("Total copies: " + copies);
}  // end insertionSort()
      public void insertionSort2() {
         int in, out;
         int comparisons = 0;
         int copies = 0;

         for (out = 1; out < nElems; out++) { // out is dividing line
            long temp = a[out]; // remove marked item
            in = out; // start shifts at out

            while (in > 0) { // until one is smaller,
               comparisons++; // increment comparison counter
               if (a[in - 1] >= temp) {
                  if (a[in - 1] == temp) {
                     temp = -1; // replace duplicate with a key value less than any normally used
                  }
                  a[in] = a[in - 1]; // shift item to right
                  copies++; // increment copy counter
               } else {
                  break; // break the loop if condition is not met
               }
               in--; // go left one position
            }
            a[in] = temp; // insert marked item
         } // end for

         // Remove duplicates at the beginning of the array
         int newSize = 0;
         for (int i = 0; i < nElems; i++) {
            if (a[i] != -1) {
               a[newSize] = a[i];
               newSize++;
            }
         }
         nElems = newSize; // Update the number of elements after removing duplicates

         System.out.println("Total comparisons: " + comparisons);
         System.out.println("Total copies: " + copies);
      }
//--------------------------------------------------------------
      public double median() {
         if (nElems % 2 == 0) {
            // If number of elements is even, return the average of the two middle elements
            int midIndex1 = (int) (nElems / 2) - 1;
            int midIndex2 = (int) (nElems / 2);
            return (a[midIndex1] + a[midIndex2]) / 2.0;
         } else {
            // If number of elements is odd, return the middle element
            int midIndex = (int) (nElems / 2);
            return a[midIndex];
         }
      }

      public void noDups() {
         int newSize = 0;
         for (int i = 0; i < nElems; i++) {
            if (i == 0 || a[i] != a[i - 1]) {
               // If it's the first element or it's not a duplicate, keep it
               a[newSize] = a[i];
               newSize++;
            }
         }
         // Update the number of elements after removing duplicates
         nElems = newSize;
      }
   }  // end class ArrayIns
////////////////////////////////////////////////////////////////
class InsertSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArrayIns arr;                 // reference to array
      arr = new ArrayIns(maxSize);  // create the array

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();                // display items

      arr.insertionSort();          // insertion-sort them

      arr.display();                // display them again
      }  // end main()
   }  // end class InsertSortApp
