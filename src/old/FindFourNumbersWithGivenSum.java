import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ss030277 on 5/6/15.
 */
public class FindFourNumbersWithGivenSum {

    public static void main(String args[]) {
        int target = 0;
        Integer[] arr = {1, 0, -1, 0, -2, 2};

        Set<List<Integer>> finalList = new HashSet<List<Integer>>();

        Arrays.sort(arr);

        int length = arr.length;
        for (int i =0; i < length; i++) {
            for (int j = i+1; j<length; j++) {
                int k = j+1;
                int l = length-1;
                while (k < l) {
                   int tempNum = arr[i] + arr[j] + arr[k] + arr[l];

                    if (tempNum > target) {
                        --l;
                    } else if (tempNum < target) {
                        ++k;
                    } else {
                        List<Integer> tempList = new ArrayList<Integer>();
                        tempList.add(arr[i]);
                        tempList.add(arr[j]);
                        tempList.add(arr[k]);
                        tempList.add(arr[l]);

                        if (finalList.isEmpty() || !finalList.contains(tempList)) {
                            finalList.add(tempList);
                        } else {
                            --l;
                            ++k;
                        }
                    }
                }
            }
        }
        System.out.println(finalList);
    }
}
