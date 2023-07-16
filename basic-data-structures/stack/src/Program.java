class MyStack {
    /***** member variables *****/
    private static final int INVALID_VALUE = Integer.MIN_VALUE;
    private final int[] stack;
    private int count;

    /***** constructors *****/
    public MyStack(int size) {
        this.stack = new int[size];
        this.count = 0;
    }

    /***** methods *****/
    // push >> O(1)
    public void push(int value) {
        // if full, print error
        if (this.count >= this.stack.length) {
            System.err.println("Push Error: Stack is already full");
            return;
        }

        // push element and increase count
        this.stack[this.count++] = value;
    }

    // pop >> O(1)
    public int pop() {
        // if empty, return min int
        if (this.count <= 0) {
            return INVALID_VALUE;
        }

        // return element value and decrease count
        return this.stack[--this.count];
    }

    // search >> O(n)
    public boolean search(int value) {
        boolean exist = false;

        // create temp stack
        int[] tempStack = new int[this.count];
        int tempStackCount = 0;

        // pop elements until find the value
        while (this.count > 0) {
            int val = this.pop();
            tempStack[tempStackCount++] = val;

            if (val == value) {
                exist = true;
                break;
            }
        }

        // push elements back to stack
        for (int i = tempStackCount - 1; i >= 0; --i) {
            this.push(tempStack[i]);
        }

        return exist;
    }

    // print
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[BOT] ");
        for (int i = 0; i < this.count; ++i) {
            builder.append(this.stack[i]);
            builder.append(' ');
        }
        builder.append("[TOP]");

        return builder.toString();
    }
}

public class Program {
    public static void main(String[] args) {
        // create stack
        MyStack myStack = new MyStack(5);

        // try pop from empty stack
        System.out.println(myStack.pop()); // -2147483648

        // push
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        System.out.println(myStack); // [BOT] 10 20 30 [TOP]
        myStack.push(40);
        myStack.push(50);
        System.out.println(myStack); // [BOT] 10 20 30 40 50 [TOP]
        myStack.push(100); // Push Error: Stack is already full

        // pop
        System.out.println(myStack.pop()); // 50
        System.out.println(myStack); // [BOT] 10 20 30 40 [TOP]

        // search
        System.out.println(myStack.search(40)); // true
        System.out.println(myStack.search(100)); // false

        System.out.println(myStack); // [BOT] 10 20 30 40 [TOP]
        myStack.push(50);
        System.out.println(myStack); // [BOT] 10 20 30 40 50 [TOP]
    }
}
