/**
 * Created by ss030277 on 5/8/15.
 */
public class FibonacciNumbers {

    public static void main(String args[]) {
        int a = -4;
        int b = -2;
        if (isFibNum(a) && isFibNum(b)) {
            printFibSeries(a, b);
        } else {
            System.out.println("Correct fib sequence could not be obtained");
        }
    }

    private static void printFibSeries(int a, int b) {
        if (a==b && a != 1 && a != -1) {
            System.out.println("Correct fib sequence could not be obtained");
            return;
        }

        boolean negFlag = false;

        if (a*b < 0) {
            negFlag = true;
        }

        System.out.println(a);
        System.out.println(b);
        int num = b;
        while ((a < 0 && num < 0) || (a > 0 && num > 0)) {
            if (negFlag) {
                num = a + b;
            } else {
                num = a - b;
            }
            System.out.println(num);
            a = b;
            b = num;
        }

        if (num != 0) {
            System.out.println("Correct fib sequence could not be obtained");
        }
    }

    private static boolean isFibNum(int x) {
        if (x ==0 || x == 1 || x == -1) {
            return true;
        }

        int j = 1;
        int i = 0;
        if (x > 0) {
            while (j < x) {
                int temp = j;
                j = i+j;
                i = temp;
            }
        } else {
            while (j > x) {
                int temp = j;
                j = i-j;
                i = temp;
            }
        }
        return j == x;
    }
}
