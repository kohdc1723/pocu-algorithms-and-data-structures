import java.util.Arrays;

public class Program {
    public static int[] findFirstAndLastIndexOf(int n, int[] arr) {
        int first = -1;
        int last = -1;

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == n) {
                if (first == -1) first = i;
                else last = i;
            }
        }

        if (last == -1) last = first;

        return new int[] {first, last};
    }

    public static void reverseChars(char[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            ++start;
            --end;
        }
    }

    public static int[] findMaxAndMinFrom(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for (int val : arr) {
            if (val < min) min = val;
            if (val > max) max = val;
        }

        return new int[] {min, max};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 7, 7, 9, 5, 1, 5};
        System.out.println(Arrays.toString(findFirstAndLastIndexOf(1, arr))); // [0, 9]

        char[] charArr = {'H', 'e', 'l', 'l', 'o'};
        reverseChars(charArr);
        System.out.println(Arrays.toString(charArr)); // [o, l, l, e, H]

        System.out.println(Arrays.toString(findMaxAndMinFrom(arr))); // [1, 9]
    }
}
