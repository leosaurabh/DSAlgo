import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss030277 on 5/14/15.
 */
public class MaxProductSubArray {

    public static void main(String args[]) {
        Integer arr[] = new Integer[]{2,3,-2,4};

        int tempPrd = arr[0];
        int finalPrd = arr[0];

        List<Integer> tempList = new ArrayList<Integer>();
        List<Integer> finalList = new ArrayList<Integer>();

        tempList.add(tempPrd);

        for (int i=1; i<arr.length; i++) {
            if (tempPrd*arr[i] > arr[i]) {
                tempPrd = tempPrd * arr[i];
                tempList.add(arr[i]);
            } else {
                tempPrd = arr[i];
                tempList.clear();
                tempList.add(arr[i]);
            }

            if (tempPrd > finalPrd) {
                finalPrd = tempPrd;
                finalList.clear();
                copyData(finalList, tempList);
            }

        }

        System.out.println(finalList + " > " + finalPrd);
    }

    private static void copyData(List<Integer> toCopy, List<Integer> fromCopy) {
        for (int fromInt : fromCopy) {
            toCopy.add(fromInt);
        }
    }
}
