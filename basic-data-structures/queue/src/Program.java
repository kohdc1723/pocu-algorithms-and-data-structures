class MyQueue {
    /***** member variables *****/
    private static final int INVALID_VALUE = Integer.MIN_VALUE;
    private final int[] queue;
    private int count;
    private int front;
    private int back;

    /***** constructors *****/
    public MyQueue(int size) {
        this.queue = new int[size];
        this.count = 0;
        this.front = 0;
        this.back = 0;
    }

    /***** methods *****/
    // enqueue >> O(1)
    public void enqueue(int value) {
        // if queue is full, print error
        if (this.count >= this.queue.length) {
            System.err.println("Enqueue Error: Queue is already full");
            return;
        }

        // insert element to the back
        this.queue[this.back] = value;
        this.back = (this.back + 1) % this.queue.length;
        ++this.count;
    }

    // dequeue >> O(1)
    public int dequeue() {
        // if queue is empty, return min int
        if (this.count <= 0) {
            return INVALID_VALUE;
        }

        // remove element from the front
        int value = this.queue[this.front];
        this.front = (this.front + 1) % this.queue.length;
        --this.count;

        return value;
    }

    // search >> O(n)
    public boolean search(int value) {
        boolean exist = false;

        // create temp array
        int[] temp = new int[this.count];
        int tempCount = 0;

        // find value by dequeue all elements
        while (this.count > 0) {
            int val = this.dequeue();
            temp[tempCount++] = val;

            if (value == val) {
                exist = true;
            }
        }

        // enqueue all elements back to queue
        for (int i = 0; i < tempCount; ++i) {
            enqueue(temp[i]);
        }

        return exist;
    }

    // print
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[FRONT] ");
        int i = 0;
        while (i < this.count) {
            builder.append(this.queue[(this.front + i) % this.queue.length]);
            builder.append(' ');

            ++i;
        }
        builder.append("[BACK]");

        return builder.toString();
    }
}

public class Program {
    public static void main(String[] args) {
        // create myQueue
        MyQueue myQueue = new MyQueue(5);

        // try dequeue from empty queue
        System.out.println(myQueue.dequeue()); // -2147483648

        // enqueue
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        System.out.println(myQueue); // [FRONT] 1 2 3 [BACK]
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        System.out.println(myQueue); // [FRONT] 1 2 3 4 5 [BACK]
        myQueue.enqueue(10); // Enqueue Error: Queue is already full

        // search
        System.out.println(myQueue.search(10)); // false
        System.out.println(myQueue.search(3)); // true
        System.out.println(myQueue); // [FRONT] 1 2 3 4 5 [BACK]

        // dequeue
        System.out.println(myQueue.dequeue()); // 1
        System.out.println(myQueue.dequeue()); // 2
        System.out.println(myQueue); // [FRONT] 3 4 5 [BACK]
    }
}
