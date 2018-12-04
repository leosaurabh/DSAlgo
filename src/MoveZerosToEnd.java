import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss030277 on 4/20/15.
 */
public class MoveZerosToEnd {

    public static void main(String args[]) {
        Integer[] arr = new Integer[]{0,6,2,0,5,4,0};
        Integer[] newArr = arrange(arr);

        for (int x: newArr) {
            System.out.println(x);
        }
    }

    private static Integer[] arrange(Integer[] input) {
        if (input == null) {
            return null;
        }

        int length = input.length;

        if(length == 0) {
            return new Integer[length];
        }

        if (length == 1) {
            return input;
        }

        int left = 0;
        int right = length-1;
        int nonZeroCount = 0;

        while (left < right) {
            if (input[right] == 0) {
                ++nonZeroCount;
                --right;
            } else if (input[right] != 0) {
                if (input[left] != 0) {
                    ++left;
                } else {
                    ++nonZeroCount;
                    int swap = input[right];
                    input[right] = input[left];
                    input[left] = swap;
                    ++left;
                    --right;
                }
            }
        }
        System.out.println(nonZeroCount);
        return input;
    }
}
