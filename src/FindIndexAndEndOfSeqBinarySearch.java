/**
 * Created by ss030277 on 5/3/15.
 */
public class FindIndexAndEndOfSeqBinarySearch {

    private static int index = 0;

    public static void main(String args[]) {
        Integer[] arr = {1,2,3,8,8,8,8,9};
        getIndex(arr, 0, 7, 0, 8);
        System.out.print(index + ",");
        getIndex(arr, 0, 7, 1, 8);
        System.out.print(index);
    }

    private static int getIndex(Integer[] arr, int start, int end, int direction, int num) {
        if (direction == 0 && arr[0] == num) {
            return 0;
        } else if (direction == 1 && arr[arr.length-1] == num) {
            return arr.length - 1;
        }

        int mid = (end + start)/2;
        if (arr[mid] == num) {
            if (direction == 0 && arr[mid-1] == num) {
                getIndex(arr, start, mid-1, direction, num);
            } else if (direction == 1 && arr[mid+1] == num) {
                getIndex(arr, mid+1, end, direction, num);
            } else {
                index = mid;
                return mid;
            }
        } else if (arr[mid] < num) {
            getIndex(arr, mid+1, end, direction, num);
        } else if (arr[mid] > num) {
            getIndex(arr, start, mid-1, direction, num);
        }
        return mid;
    }
}
