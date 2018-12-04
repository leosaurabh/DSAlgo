import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss030277 on 5/31/15.
 */
public class PrintOffset {

    public static void main(String args[]) {
        Integer[] arr = new Integer[]{0,0,0,1,1,3,4,5,5};
        System.out.println(getOffsets(arr));
    }

    private static List<Integer> getOffsets(Integer[] arr) {
        if (arr == null) {
            return null;
        }

        int length = arr.length;
        List<Integer> offsets = new ArrayList<Integer>();

        if (length == 0) {
            return offsets;
        }

        int count = 0;
        int lastVal = arr[0];
        int offset = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == lastVal) {
                ++count;
            } else {
                if (count > 1) {
                    offsets.add(offset);
                    count = 1;
                }

                lastVal = arr[i];
                offset = i;
            }
        }

        if (count > 1) {
            offsets.add(offset);
        }

        return offsets;
    }
}
