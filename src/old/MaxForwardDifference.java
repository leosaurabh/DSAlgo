/**
 * Created by ss030277 on 5/16/15.
 */
public class MaxForwardDifference {

    public static void main(String args[]) {
        Integer arr[] = new Integer[]{2, 3, 10, 6, 4, 8, 1};
        System.out.println(getDiff(arr));
    }

    private static int getDiff(Integer arr[]) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int i = 1;
        int length = arr.length;

        int min = arr[0];
        int diff = Integer.MIN_VALUE;

        while (i < length) {
            if (arr[i] - min > diff) {
                diff = arr[i] - min;
            }
            if (min > arr[i]) {
                min = arr[i];
            }
            ++i;
        }
        return diff;
    }
}
