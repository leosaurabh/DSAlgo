/**
 * Created by ss030277 on 5/6/15.
 */
public class IndexOrInsertPosition {

    private static int index;

    public static void main(String args[]) {
        Integer arr[] = {1,2,4,6,7};
        int num = 3;
        setIndex(arr, num, 0, arr.length-1);
        System.out.println(index);
    }

    private static void setIndex(Integer arr[], int num, int start, int end) {
        if (arr == null) {
            return;
        }

        if (start > end) {
            return;
        }

        int length = arr.length;
        int mid = (start+end)/2;
        int value = arr[mid];

        if (value == num) {
            index = mid;
        } else if (value > num) {
            if (mid-1 > 0 && arr[mid-1] < num) {
                index = mid;
            } else if (arr[mid-1] > num) {
                setIndex(arr, num, start, mid-1);
            }
        } else if (value < num) {
            if (mid+1 < length && arr[mid+1] > num) {
                index = mid+1;
            } else if (arr[mid+1] > num) {
                setIndex(arr, num, mid+1, end);
            }
        }
    }
}
