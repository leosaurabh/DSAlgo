/**
 * Created by ss030277 on 5/20/15.
 */
public class SelectionSort {

    public static void main(String args[]) {
        Integer[] arr = new Integer[]{3,-5,-3,4,20,-12};
        insertionSort(arr);
    }

    private static void insertionSort(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int length = arr.length;
        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i=0; i<length; i++) {
            for (int j=i; j<length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }

            arr[index] = arr[i];
            arr[i] = min;
            min = Integer.MAX_VALUE;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
