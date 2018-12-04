/**
 * Created by ss030277 on 5/20/15.
 */
public class InsertionSort {

    public static void main(String args[]) {
        Integer[] arr = new Integer[]{3,-5,-3,4,20,-12};
        insertionSort(arr);
    }

    private static void insertionSort(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int length = arr.length;

        for (int i=1; i < length; i++) {
            int num = arr[i];
            int x = i;
            for (int j=i-1; j >= 0; j--) {
                if (arr[j] > num) {
                    int temp = arr[j];
                    arr[j] = num;
                    arr[x] = temp;
                    x = j;
                }
            }
        }

        for (int m: arr) {
            System.out.print(m + " ");
        }
    }
}
