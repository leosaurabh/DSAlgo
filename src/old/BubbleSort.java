/**
 * Created by ss030277 on 5/19/15.
 */
public class BubbleSort {

    public static void main (String args[]) {
        Integer[] arr = new Integer[]{3,-5,-3,4,20,-12};
        bubbleSort(arr);
    }

    private static void bubbleSort(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int length = arr.length;
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int x=0; x < length-1; x++) {
                if (arr[x] > arr[x+1]) {
                    arr[x] = arr[x]^arr[x+1];
                    arr[x+1] = arr[x]^arr[x+1];
                    arr[x] = arr[x]^arr[x+1];
                    swapped = true;
                }
            }
        }

        for (int m: arr) {
            System.out.print(m + " ");
        }
    }
}
