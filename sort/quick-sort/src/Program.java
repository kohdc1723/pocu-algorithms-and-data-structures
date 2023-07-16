import java.util.Arrays;

public class Program {
    public static void quickSortAscendingRecursive(int[] nums, int left, int right) {
        // base case
        if (left >= right) return;

        // general case
        int pivot = nums[right];
        int leftPointer = left;

        for (int i = left; i < right; ++i) {
            if (nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[leftPointer];
                nums[leftPointer] = temp;

                ++leftPointer;
            }
        }

        int temp = nums[leftPointer];
        nums[leftPointer] = nums[right];
        nums[right] = temp;

        int indexOfPivot = leftPointer;
        // sort left part
        quickSortAscendingRecursive(nums, left, indexOfPivot - 1);
        // sort right part
        quickSortAscendingRecursive(nums, indexOfPivot + 1, right);
    }

    public static void quickSortDescendingRecursive(int[] nums, int left, int right) {
        if (left >= right) return;

        int pivot = nums[right];
        int leftPointer = left;

        for (int i = left; i < right; ++i) {
            if (nums[i] > pivot) {
                int temp = nums[i];
                nums[i] = nums[leftPointer];
                nums[leftPointer] = temp;

                ++leftPointer;
            }
        }

        int temp = nums[leftPointer];
        nums[leftPointer] = nums[right];
        nums[right] = temp;

        int indexOfPivot = leftPointer;
        quickSortDescendingRecursive(nums, left, indexOfPivot - 1);
        quickSortDescendingRecursive(nums, indexOfPivot + 1, right);
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 8, 6, 0, 8, 1, 7, 2, 3};
        quickSortAscendingRecursive(nums1, 0, nums1.length - 1);
        System.out.println(Arrays.toString(nums1)); // [0, 0, 0, 1, 1, 2, 3, 6, 7, 8, 8]

        int[] nums2 = {0, 1, 0, 8, 6, 0, 8, 1, 7, 2, 3};
        quickSortDescendingRecursive(nums2, 0, nums1.length - 1);
        System.out.println(Arrays.toString(nums2)); // [8, 8, 7, 6, 3, 2, 1, 1, 0, 0, 0]
    }
}
