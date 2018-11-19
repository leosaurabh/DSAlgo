import java.util.HashMap;
import java.util.Map;

/**
 * Created by ss030277 on 5/28/15.
 */
public class DiceHistogram {

    public static void main(String args[]) {

    }

    private static Map<Integer, Integer> getMap(int diceCount, int faceCount) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        if (diceCount <= 0 || faceCount <= 0) {
            return map;
        }

        int totalCombinationCount = (int) Math.pow(faceCount, diceCount);
        int minSum = diceCount;
        int maxSum = faceCount * diceCount;
        int count = minSum;
        int total = minSum + maxSum;
        int mid = (total)/2;
        int sum = 0;
        int additive = 0;

        while (minSum < mid) {
            sum = sum + 2 * (minSum + additive);
            map.put(minSum, minSum + additive);
            map.put(total - minSum, minSum + additive);
            ++minSum;
            additive = diceCount - 1;
        }

        return map;
    }
}
