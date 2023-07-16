public class Program {
    public static int binarySearchRecursive(int[] nums, int left, int right, int value) {
        int mid = (left + right) / 2;

        // base case
        if (left > right) return -1;

        // general case
        if (nums[mid] > value) {
            return binarySearchRecursive(nums, left, mid - 1, value);
        } else if (nums[mid] < value) {
            return binarySearchRecursive(nums, mid + 1, right, value);
        } else {
            return mid;
        }
    }

    public static int binarySearchIterative(int[] nums, int value) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] > value) {
                right = mid - 1;
            } else if (nums[mid] < value) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int indexOfRotatedArray(int[] nums, int left, int right, int value) {
        if (left > right) return -1;

        int mid = (left + right) / 2;

        if (nums[mid] == value) return mid;

        // binary search only works in sorted part of array
        // if left ~ mid is sorted
        if (nums[mid] >= nums[left]) {
            // if value is between left and mid
            if (nums[left] <= value && value <= nums[mid]) {
                return indexOfRotatedArray(nums, left, mid - 1, value);
            } else {
                return indexOfRotatedArray(nums, mid + 1, right, value);
            }
        }
        // if mid ~ right is sorted
        else {
            // if value is between mid and right
            if (nums[mid] <= value && value <= nums[right]) {
                return indexOfRotatedArray(nums, mid + 1, right, value);
            } else {
                return indexOfRotatedArray(nums, left, mid - 1, value);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 7, 9, 10, 11, 15, 19, 21, 25};
        System.out.println(binarySearchRecursive(nums, 0, nums.length - 1, 1)); // 0
        System.out.println(binarySearchRecursive(nums, 0, nums.length - 1, 7)); // 3
        System.out.println(binarySearchRecursive(nums, 0, nums.length - 1, 19)); // 8
        System.out.println(binarySearchRecursive(nums, 0, nums.length - 1, 25)); // 10
        System.out.println(binarySearchRecursive(nums, 0, nums.length - 1, 30)); // -1

        System.out.println(binarySearchIterative(nums, 1)); // 0
        System.out.println(binarySearchIterative(nums, 7)); // 3
        System.out.println(binarySearchIterative(nums, 19)); // 8
        System.out.println(binarySearchIterative(nums, 25)); // 10
        System.out.println(binarySearchIterative(nums, 30)); // -1

        int[] rotatedNums = {20, 25, 26, 29, 33, 1, 3, 5, 6, 10, 11, 19};
        System.out.println(indexOfRotatedArray(rotatedNums, 0, rotatedNums.length - 1, 20));
        System.out.println(indexOfRotatedArray(rotatedNums, 0, rotatedNums.length - 1, 33));
        System.out.println(indexOfRotatedArray(rotatedNums, 0, rotatedNums.length - 1, 1));
        System.out.println(indexOfRotatedArray(rotatedNums, 0, rotatedNums.length - 1, 19));
        System.out.println(indexOfRotatedArray(rotatedNums, 0, rotatedNums.length - 1, 50));
    }
}
