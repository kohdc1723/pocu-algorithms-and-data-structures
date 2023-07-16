import java.util.Arrays;

public class Program {
    public static void selectionSortAscending(int[] nums) {
        for (int i = 0; i <= nums.length - 2; ++i) {
            int indexOfMin = i;
            for (int j = i + 1; j <= nums.length - 1; ++j) {
                if (nums[j] < nums[indexOfMin]) {
                    indexOfMin = j;
                }
            }

            int temp = nums[indexOfMin];
            nums[indexOfMin] = nums[i];
            nums[i] = temp;
        }
    }

    public static void selectionSortDescending(int[] nums) {
        for (int i = 0; i <= nums.length - 2; ++i) {
            int indexOfMax = i;
            for (int j = i + 1; j <= nums.length - 1; ++j) {
                if (nums[j] > nums[indexOfMax]) {
                    indexOfMax = j;
                }
            }

            int temp = nums[indexOfMax];
            nums[indexOfMax] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 8, 6, 0, 8, 1, 7, 2, 3};
        selectionSortAscending(nums1);
        System.out.println(Arrays.toString(nums1)); // [0, 0, 0, 1, 1, 2, 3, 6, 7, 8, 8]

        int[] nums2 = {0, 1, 0, 8, 6, 0, 8, 1, 7, 2, 3};
        selectionSortDescending(nums2);
        System.out.println(Arrays.toString(nums2)); // [8, 8, 7, 6, 3, 2, 1, 1, 0, 0, 0]
    }
}
