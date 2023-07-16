import java.util.Arrays;

class MyHashTable {
    /***** member variables *****/
    private static final int INITIAL_VALUE = Integer.MIN_VALUE;
    private final int[] hashtable;

    /***** constructors *****/
    public MyHashTable(int size) {
        this.hashtable = new int[size];
        Arrays.fill(this.hashtable, INITIAL_VALUE);
    }

    /***** methods *****/
    // add >> O(1)
    public boolean add(int value) {
        // decide the start index
        int startIndex = value % this.hashtable.length;
        if (startIndex < 0) {
            startIndex += this.hashtable.length;
        }

        int i = startIndex;
        do {
            // if value is already exist in the table or index is empty, add value and return true
            if (this.hashtable[i] == value || this.hashtable[i] == INITIAL_VALUE) {
                this.hashtable[i] = value;

                return true;
            }

            // update i
            i = (i + 1) % this.hashtable.length;
        } while (i != startIndex);

        // if failed to add, return false
        return false;
    }

    // search >> O(1)
    public boolean hasValue(int value) {
        // decide the start index
        int startIndex = value % this.hashtable.length;
        if (startIndex < 0) {
            startIndex += this.hashtable.length;
        }

        int i = startIndex;
        do {
            if (this.hashtable[i] == value) {
                return true;
            }

            if (this.hashtable[i] == INITIAL_VALUE) {
                return false;
            }

            // update i
            i = (i + 1) % this.hashtable.length;
        } while (i != startIndex);

        return false;
    }

    // remove >> O(1)
    public boolean remove(int value) {
        // decide the start index
        int startIndex = value % this.hashtable.length;
        if (startIndex < 0) {
            startIndex += this.hashtable.length;
        }

        int i = startIndex;
        do {
            if (this.hashtable[i] == value) {
                this.hashtable[i] = INITIAL_VALUE;
                return true;
            }

            // update i
            i = (i + 1) % this.hashtable.length;
        } while (i != startIndex);

        return false;
    }

    // print
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < this.hashtable.length; ++i) {
            builder.append("[");
            builder.append(i);
            builder.append("] ");
            builder.append(this.hashtable[i]);
            builder.append('\n');
        }

        return builder.toString();
    }
}

public class Program {
    public static void main(String[] args) {
        // create myHashTable
        MyHashTable myHashTable = new MyHashTable(13);

        // add
        myHashTable.add(24);
        myHashTable.add(32);
        myHashTable.add(11);
        myHashTable.add(9);
        myHashTable.add(15);
        myHashTable.add(40);
        myHashTable.add(75);
        System.out.println(myHashTable);
        /*
        * [0] -2147483648
        * [1] 40
        * [2] 15
        * [3] -2147483648
        * [4] -2147483648
        * [5] -2147483648
        * [6] 32
        * [7] -2147483648
        * [8] -2147483648
        * [9] 9
        * [10] 75
        * [11] 24
        * [12] 11
        * */

        // search
        System.out.println(myHashTable.hasValue(11)); // true
        System.out.println(myHashTable.hasValue(100)); // false

        // remove
        System.out.println(myHashTable.remove(100)); // false
        System.out.println(myHashTable.remove(32)); // true
        System.out.println(myHashTable);
        /*
         * [0] -2147483648
         * [1] 40
         * [2] 15
         * [3] -2147483648
         * [4] -2147483648
         * [5] -2147483648
         * [6] -2147483648
         * [7] -2147483648
         * [8] -2147483648
         * [9] 9
         * [10] 75
         * [11] 24
         * [12] 11
         * */
    }
}
