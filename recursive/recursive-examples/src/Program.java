public class Program {
    public static int sumRecursive(int n) {
        // base case
        if (n == 1) return 1;

        // general case
        return n + sumRecursive(n - 1);
    }

    public static int sumTailRecursive(int n, int sum) {
        // base case
        if (n == 0) return sum;

        // general case
        return sumTailRecursive(n - 1, sum + n);
    }

    public static int arraySumRecursive(int[] arr, int index) {
        // base case
        if (index == arr.length) return 0;

        // general case
        return arr[index] + arraySumRecursive(arr, index + 1);
    }

    public static int factorialRecursive(int n) {
        // base case
        if (n == 0) return 1;

        // general case
        return n * factorialRecursive(n - 1);
    }

    public static int factorialTailRecursive(int n, int fac) {
        // base case
        if (n == 0) return fac;

        // general case
        return factorialTailRecursive(n - 1, fac * n);
    }

    public static int powerRecursive(int x, int n) {
        // base case
        if (n == 0) return 1;

        // general case
        return x * powerRecursive(x, n - 1);
    }

    public static int fibonacciRecursive(int n) {
        // base case
        if (n == 0 || n == 1) return 1;

        // general case
        return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumRecursive(5)); // 15
        // System.out.println(sumRecursive(100000)); // stack overflow
        // System.out.println(sumTailRecursive(100000, 0)); // Java TCO x => stack overflow
        System.out.println(sumTailRecursive(5, 0)); // 15
        System.out.println(sumTailRecursive(10, 0)); // 55

        System.out.println(factorialRecursive(5)); // 120
        System.out.println(factorialTailRecursive(5, 1)); // 120

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arraySumRecursive(arr, 0)); // 15

        System.out.println(powerRecursive(2, 4)); // 16

        for (int i = 0; i < 10; ++i) {
            System.out.print(fibonacciRecursive(i));
            System.out.print(' ');
        } // 1 1 2 3 5 8 13 21 34 55
    }
}