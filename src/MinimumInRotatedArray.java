public class MinimumInRotatedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {5, 6, 1, 2, 3, 4}, 0, 5));
    }
    // 5, 6, 1, 2, 3, 4
    private static int findMin(int arr[], int low, int high) {
        if (low >= high) {
            return arr[low];
        }

        if (low + 1 == high) {
            return Math.min(arr[low], arr[high]);
        }

        int middle = (low + high)/2;
        if (arr[middle] > arr[middle - 1]) {
            return findMin(arr, low, middle - 1);
        } else {
            if (arr[middle] > arr[high]) {
                return findMin(arr, low, middle - 1);
            } else {
                return findMin(arr, middle, high);
            }
        }
    }
}
