/**
 * Created by ss030277 on 5/5/15.
 */
public class MedianOfSortedArrays {

    private static int median = -1;

    public static void main(String args[]) {
        Integer arr1[] = {1,3,5,6,7};
        Integer arr2[] = {2,4,6,8};

        int start1 = 0;
        int start2 = 0;
        int end1 = arr1.length;
        int end2 = arr1.length;
        int median1 = 0;
        int median2 = 0;

        while ((end1-start1) > 2 && (end2-start2) > 2) {
            median1 = getMedian(arr1);
            median2 = getMedian(arr2);

            if (median1 < 0 || median2 < 0) {
                System.out.println("Error");
                break;
            } else if (median1 == median2) {
                median = median1;
                break;
            } else if (median1 > median2) {
                end1 = median1;
                start2 = median2;
            } else if (median2 > median1) {
                start1 = median1;
                end2 = median2;
            }
        }
        if (median < 0) {
            median = (median1 + median2) / 2;
        }
        System.out.println(median);
    }

    private static int getMedian(Integer[] arr) {
        int length = arr.length;
        if (length > 0) {
            return arr[length/2];
        }
        return median;
    }
}
