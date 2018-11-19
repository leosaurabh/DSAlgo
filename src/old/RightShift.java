import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss030277 on 5/30/15.
 */
public class RightShift {

    public static void main(String args[]) {
        System.out.println(rightShift(15, 1));
    }

    private static int rightShift(int num, int count) {
        if (count <= 0) {
            return num;
        }

        int factor = num < 0 ? -1 : 1;

        List<Integer> binary = new ArrayList<Integer>();
        while (num > 0) {
            binary.add(num%2);
            num /= 2;
        }

        int finalNumber = 0;
        int length = binary.size();
        for (int j = length-1; j >= count; --j) {
            finalNumber = 2*finalNumber + binary.get(j);
        }

        return factor*finalNumber;
    }
}
