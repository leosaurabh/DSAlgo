import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ss030277 on 5/6/15.
 */
public class ThreeSum {
    public static void main(String args[]) {
        int target = 0;
        Integer[] arr = { 1, 0, -1, 0, -2, 2 };

        Set<List<Integer>> finalList = new HashSet<List<Integer>>();

        Arrays.sort(arr);
        int length = arr.length;
        for (int i=0; i<length; i++) {
            int j = i+1;
            int k = length - 1;

            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum < target) {
                    ++j;
                } else if (sum > target) {
                    --k;
                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(arr[k]);

                    if (!finalList.contains(list)) {
                        finalList.add(list);
                    } else {
                        ++j;
                        --k;
                    }
                }
            }
        }
        System.out.println(finalList);
    }
}
