public class SearchTargetRange {

    public static void main(String args[]) {
        int[] result = searchRange(new int[] {5,7,7,8,8,10}, 8);
        System.out.println(result);
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }

        int[] result = { nums.length, -1 };
        search(nums, target, result, 0, nums.length - 1);
        return result;
    }

    private static void search(int[] nums, int target, int[] result, int start, int end) {
        if (start > end) {
            return;
        }

        if (start == end) {
            compute(nums, target, result, start);
            return;
        }

        int middle = (start + end)/2;
        if (nums[middle] == target) {
            compute(nums, target, result, middle);
        }
        if (nums[middle] >= target)
            search(nums, target, result, start, middle - 1);
        if (nums[middle] <= target)
            search(nums, target, result, middle + 1, end);
    }

    private static void compute(int[] nums, int target, int[] result, int index) {
        if (nums[index] == target) {
            if (index > result[1]) {
                result[1] = index;
            } else if (index < result[0]) {
                result[0] = index;
            }
        }
    }
}
