class MyArray {
    /***** member variables *****/
    private static final int INVALID_INDEX = -1;
    private static final int INVALID_VALUE = Integer.MIN_VALUE;
    private int count;
    private final int[] array;

    /***** constructors *****/
    public MyArray(int size) {
        this.array = new int[size];
        this.count = 0;
    }

    /***** methods *****/
    // insertion >> O(n)
    public void insertAt(int index, int value) {
        // if full, print error
        if (this.count >= this.array.length) {
            System.err.println("Insertion Error: Array is already full");
            return;
        }

        // if index > count, print error
        if (index > this.count) {
            System.err.println("Insertion Error: Index is invalid");
            return;
        }

        // if insert in the middle, push back elements
        for (int i = this.count; i > index; --i) {
            this.array[i] = this.array[i - 1];
        }

        // insert value in index and increase count
        this.array[index] = value;
        ++this.count;
    }

    // removal >> O(n)
    public void removeAt(int index) {
        // if empty, print error
        if (this.count <= 0) {
            System.err.println("Removal Error: Array is already empty");
            return;
        }

        // if index >= count, print error
        if (index >= this.count) {
            System.err.println("Removal Error: Index is invalid");
            return;
        }

        // if remove in the middle, pull elements
        for (int i = index; i < this.count - 1; ++i) {
            this.array[i] = this.array[i + 1];
        }

        // remove element == decrease count
        --this.count;
    }

    // search >> O(n)
    public int search(int value) {
        // if value is found, return its index
        for (int i = 0; i < this.count; ++i) {
            if (this.array[i] == value) {
                return i;
            }
        }

        // if value is not found, return -1
        return INVALID_INDEX;
    }

    // access >> O(1)
    public int getValueAt(int index) {
        // if index >= count, return min int value
        if (index >= this.count) {
            return INVALID_VALUE;
        }

        return this.array[index];
    }

    // print
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < this.count; ++i) {
            builder.append(this.array[i]);
            builder.append(' ');
        }

        return builder.toString();
    }
}

public class Program {
    public static void main(String[] args) {
        // create myArray
        MyArray myArray = new MyArray(5);

        // try remove from empty array
        myArray.removeAt(0); // Removal Error: Array is already empty

        // insert in order
        myArray.insertAt(0, 20);
        myArray.insertAt(1, 30);
        myArray.insertAt(2, 50);
        System.out.println(myArray); // 20 30 50
        // insert in the middle
        myArray.insertAt(4, 0); // Insertion Error: Index is invalid
        myArray.insertAt(0, 10);
        myArray.insertAt(3, 40);
        myArray.insertAt(4, 100); // Insertion Error: Array is already full
        System.out.println(myArray); // 10 20 30 40 50

        // remove
        myArray.removeAt(4);
        System.out.println(myArray); // 10 20 30 40
        myArray.removeAt(0);
        System.out.println(myArray); // 20 30 40
        myArray.removeAt(3); // Removal Error: Index is invalid

        // search
        System.out.println(myArray.search(50)); // -1
        System.out.println(myArray.search(30)); // 1

        // access
        System.out.println(myArray.getValueAt(3)); // -2147483648
        System.out.println(myArray.getValueAt(0)); // 20
    }
}
