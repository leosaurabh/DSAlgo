import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss030277 on 5/14/15.
 */
public class MaxSumSubArray {

    public static void main(String args[]) {
        Integer arr[] = new Integer[]{-2,1,-3,4,-1,2,1,-5,4};

        int tempSum = arr[0];
        int finalSum = arr[0];

        List<Integer> tempList = new ArrayList<Integer>();
        List<Integer> finalList = new ArrayList<Integer>();

        tempList.add(tempSum);

        for (int i=1; i<arr.length; i++) {
            if (tempSum+arr[i] > arr[i]) {
                tempSum = tempSum + arr[i];
                tempList.add(arr[i]);
            }

            if (tempSum > finalSum) {
                finalSum = tempSum;
                finalList.clear();
                copyData(finalList, tempList);
            }

            if (tempSum+arr[i] <= arr[i]){
                tempSum = arr[i];
                tempList.clear();
                tempList.add(arr[i]);
            }
        }

        System.out.println(finalList + " > " + finalSum);
    }

    private static void copyData(List<Integer> toCopy, List<Integer> fromCopy) {
        for (int fromInt : fromCopy) {
            toCopy.add(fromInt);
        }
    }
}
