/**
 * Created by ss030277 on 5/20/15.
 */
public class ExcelColumnToValue {

    public static void main (String args[]) {
        String inp = "AA";
        System.out.println(getValue(inp));
    }

    private static int getValue(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }

        char[] arr = str.toCharArray();
        int value = 0;
        int subFactor = ((int) 'A') - 1;

        for (char ch : arr) {
            int num = (int) ch;
            value = 26*value + (num - subFactor);
        }

        return value;
    }
}
