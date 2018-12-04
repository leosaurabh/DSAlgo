import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ss030277 on 5/6/15.
 */
public class ThreeClosestSum {
    public static void main(String args[]) {
        int target = 1;
        Integer[] arr = {-1, 2, 1, -4};

        List<Integer> finalList = new ArrayList<Integer>(3);
        int finalDiff = Integer.MAX_VALUE;
        int finalSum = -1;

        Arrays.sort(arr);

        int length = arr.length;
        for (int i=0; i<length; i++) {
            int j = i+1;
            int k = length - 1;

            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                int diff = sum > target ? sum-target : target-sum;

                if (diff < finalDiff) {
                    finalDiff = diff;
                    finalSum = sum;
                    finalList.clear();
                    finalList.add(arr[i]);
                    finalList.add(arr[j]);
                    finalList.add(arr[k]);
                }
                ++j;
                --k;
            }
        }
        System.out.println(finalList);
        System.out.println("Sum is:" + finalSum);
    }
}
