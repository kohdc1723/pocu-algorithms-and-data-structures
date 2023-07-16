import java.util.Arrays;

public class Program {
    public static void insertionSortAscending(int[] nums) {
        for (int i = 1; i <= nums.length - 1; ++i) {
            int key = nums[i];

            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                --j;
            }

            nums[j + 1] = key;
        }
    }

    public static void insertionSortDescending(int[] nums) {
        for (int i = 1; i <= nums.length - 1; ++i) {
            int key = nums[i];

            int j = i - 1;
            while (j >= 0 && nums[j] < key) {
                nums[j + 1] = nums[j];
                --j;
            }

            nums[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 3, 1, 3, 4, 6, 2};
        insertionSortAscending(nums1);
        System.out.println(Arrays.toString(nums1)); // [1, 2, 3, 3, 4, 5, 6]

        int[] nums2 = {5, 3, 1, 3, 4, 6, 2};
        insertionSortDescending(nums2);
        System.out.println(Arrays.toString(nums2)); // [6, 5, 4, 3, 3, 2, 1]
    }
}
