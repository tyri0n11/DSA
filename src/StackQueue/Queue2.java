package StackQueue;

class Queue2 {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;

    public Queue2(int s) // constructor
    {
        maxSize = s + 1; // array is 1 cell larger than requested
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
    }

    public void insert(long j) // put item at rear of queue
    {
        if (rear == maxSize - 1)
            rear = -1;
        queArray[++rear] = j;
    }

    public long remove() // take item from front of queue
    {
        long temp = queArray[front++];
        if (front == maxSize)
            front = 0;
        return temp;
    }

    public long peek() // peek at front of queue
    {
        return queArray[front];
    }

    public boolean isEmpty() // true if queue is empty
    {
        return (rear + 1 == front || (front + maxSize - 1 == rear));
    }

    public boolean isFull() // true if queue is full
    {
        return (rear + 2 == front || (front + maxSize - 2 == rear));
    }

    public int size() // (assumes queue not empty)
    {
        if (rear >= front) // contiguous sequence
            return rear - front + 1;
        else // broken sequence
            return (maxSize - front) + (rear + 1);
    }
} // end class Queue2

class Queue2Test {
    public static void main(String[] args) {
        Queue2 theQueue = new Queue2(5); // Create a queue with a maximum size of 5

        // Insertion
        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);

        // Removal
        System.out.println("Removed item: " + theQueue.remove());
        System.out.println("Removed item: " + theQueue.remove());

        // Insertion
        theQueue.insert(40);
        theQueue.insert(50);
        theQueue.insert(60); // This will wrap around since maxSize is 6

        // Peek
        System.out.println("Front item: " + theQueue.peek());

        // Check if empty
        System.out.println("Is queue empty? " + theQueue.isEmpty());

        // Check if full
        System.out.println("Is queue full? " + theQueue.isFull());
    }
}

