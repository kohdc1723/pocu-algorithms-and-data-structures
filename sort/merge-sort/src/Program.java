import java.util.Arrays;

public class Program {
    public static void mergeSortAscending(int[] nums, int start, int end) {
        // base case
        if (start >= end) return;

        // general case
        // divide
        int mid = (start + end) / 2;
        mergeSortAscending(nums, start, mid);
        mergeSortAscending(nums, mid + 1, end);

        // merge
        int[] leftArr = new int[mid - start + 1];
        int[] rightArr = new int[end - mid];
        System.arraycopy(nums, start, leftArr, 0, leftArr.length);
        System.arraycopy(nums, mid + 1, rightArr, 0, rightArr.length);

        int l = 0;
        int r = 0;
        int index = start;
        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] <= rightArr[r]) nums[index++] = leftArr[l++];
            else nums[index++] = rightArr[r++];
        }

        while (l < leftArr.length) {
            nums[index++] = leftArr[l++];
        }

        while (r < rightArr.length) {
            nums[index++] = rightArr[r++];
        }
    }

    public static void mergeSortDescending(int[] nums, int start, int end) {
        // base case
        if (start >= end) return;

        // general case
        // divide
        int mid = (start + end) / 2;
        mergeSortDescending(nums, start, mid);
        mergeSortDescending(nums, mid + 1, end);

        // merge
        int[] leftArr = new int[mid - start + 1];
        int[] rightArr = new int[end - mid];
        System.arraycopy(nums, start, leftArr, 0, leftArr.length);
        System.arraycopy(nums, mid + 1, rightArr, 0, rightArr.length);

        int l = 0;
        int r = 0;
        int index = start;
        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] > rightArr[r]) nums[index++] = leftArr[l++];
            else nums[index++] = rightArr[r++];
        }

        while (l < leftArr.length) {
            nums[index++] = leftArr[l++];
        }

        while (r < rightArr.length) {
            nums[index++] = rightArr[r++];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 3, 6, 8, 6, 9, 1, 9, 4, 5 };
        mergeSortAscending(nums1, 0, nums1.length - 1);
        System.out.println(Arrays.toString(nums1)); // [1, 2, 3, 4, 5, 6, 6, 8, 9, 9]

        int[] nums2 = { 2, 3, 6, 8, 6, 9, 1, 9, 4, 5 };
        mergeSortDescending(nums2, 0, nums2.length - 1);
        System.out.println(Arrays.toString(nums2)); // [9, 9, 8, 6, 6, 5, 4, 3, 2, 1]
    }
}
