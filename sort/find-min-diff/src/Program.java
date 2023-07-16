import java.util.Arrays;
import java.util.Random;

public class Program {
    /*
    * brute-force => nested loop => O(n^2)
    * sort and compare => [ sort: O(nlogn) ] + [ compare: O(n) => O(nlogn) ]
    * */
    public static int findMinDiff(int[] nums) {
        Arrays.sort(nums); // O(nlogn)

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; ++i) {
            int diff = Math.abs(nums[i + 1] - nums[i]);
            if (diff < minDiff) minDiff = diff;
        } // O(n)

        return minDiff;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(nums)); // unsorted
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums)); // sorted

        System.out.println(findMinDiff(nums));
    }
}
