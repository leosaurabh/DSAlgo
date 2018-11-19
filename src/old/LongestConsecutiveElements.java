import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ss030277 on 5/6/15.
 */
public class LongestConsecutiveElements {

    public static void main(String args[]) {
        Integer arr[] = {100, 101, 4, 200, 1, 3, 2, 5, 66, 102, 104, 103, 105};
        int length = arr.length;
        int i = 0;
        Arrays.sort(arr);
        List<Integer> output = new ArrayList<Integer>();
        int sum = Integer.MIN_VALUE;
        List<Integer> finalData = new ArrayList<Integer>();
        int count = 1;

        while (i < length-1) {
            int value = arr[i];
            int nextValue = arr[i+1];
            output.add(value);

            if (nextValue-value == 1) {
                if (i+1 == length-1) {
                    output.add(value);
                }
                ++count;
            } else {
                if (count > sum) {
                    sum = count;
                    finalData.clear();
                    copyData(finalData, output);
                }
                count = 1;
                output.clear();
            }
            ++i;
        }
        System.out.println("Sum:" + sum);
        System.out.println("Data:"+finalData);
    }

    private static void copyData(List<Integer> dest, List<Integer> src) {
        for (int x : src) {
            dest.add(x);
        }
    }
}
