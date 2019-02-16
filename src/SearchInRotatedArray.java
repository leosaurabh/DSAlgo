public class SearchInRotatedArray {

    public static void main(String args[]) {
        int[] arr = {5,1,2,3,4};
        System.out.println(search(arr, 4));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 2) {
            return nums[0] == target ? 0 : nums[1] == target ? 1 : -1;
        }

        if (nums[0] < nums[nums.length - 1]) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        int pivot = findPivotIndex(nums, 0, nums.length - 1);
        if (pivot < 0) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        if (target == nums[pivot]) {
            return pivot;
        }

        int index = binarySearch(nums, target, 0, pivot - 1);
        if (index < 0) {
            index = binarySearch(nums, target, pivot, nums.length - 1);
        }
        return index;
    }

    private static int findPivotIndex(int[] nums, int start, int end) {
        if (start > end){
            return -1;
        }

        if (start == end) {
            return start;
        }

        int middle = (start + end)/2;
        if (nums[middle] > nums[middle + 1]) {
            return middle + 1;
        } else {
            if (nums[start] > nums[middle]) {
                return findPivotIndex(nums, start, middle - 1);
            } else {
                return findPivotIndex(nums, middle + 1, end);
            }
        }
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        if (start == end) {
            return nums[start] == target ? start : -1;
        }

        int middle = (start + end)/2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] < target) {
            return binarySearch(nums, target, middle + 1, end);
        } else {
            return binarySearch(nums, target, start, middle - 1);
        }
    }
}
