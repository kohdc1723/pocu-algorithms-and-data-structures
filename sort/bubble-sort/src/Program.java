import java.util.Arrays;

public class Program {
    public static void bubbleSortAscending(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = 0; j <= nums.length - 2 - i; ++j) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortDescending(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = 0; j <= nums.length - 2 - i; ++j) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 8, 6, 0, 8, 1, 7, 2, 3};

        bubbleSortAscending(nums);
        System.out.println(Arrays.toString(nums)); // [0, 0, 0, 1, 1, 2, 3, 6, 7, 8, 8]

        bubbleSortDescending(nums);
        System.out.println(Arrays.toString(nums)); // [8, 8, 7, 6, 3, 2, 1, 1, 0, 0, 0]
    }
}
