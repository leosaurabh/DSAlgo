/**
 * Created by ss030277 on 5/6/15.
 */
public class AtoI {

    public static void main(String args[]) {
       String str = "-123  ";
        System.out.println(convertToInteger(str));
    }

    private static int convertToInteger(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("Invalid input string : " + str);
            return 0;
        }

        str = str.trim();

        double output = 0.00;
        int rangeStart = (int) '0';
        int rangeEnd = rangeStart + 9;
        char arr[] = str.toCharArray();
        int length = str.length();
        int multFactor = 1;

        for (int i = 0; i < length; i++) {
             int ascii = (int) arr[i];
             if (ascii < rangeStart || ascii > rangeEnd) {
                 if (i==0 && arr[i] == '-') {
                     multFactor = -1;
                 } else if (i==0 && arr[i] == '+') {
                     multFactor = 1;
                 } else {
                     throw new IllegalArgumentException("Invalid string : " + str);
                 }
             } else {
                 output = 10*output + Integer.parseInt(String.valueOf(arr[i]));
             }
        }

        output = multFactor*output;

        if (output > Integer.MAX_VALUE) {
            output = Integer.MAX_VALUE;
        } else if (output < Integer.MIN_VALUE) {
            output = Integer.MIN_VALUE;
        }

        return (int) output;
    }
}
