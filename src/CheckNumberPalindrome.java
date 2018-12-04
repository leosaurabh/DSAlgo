/**
 * Created by ss030277 on 6/3/15.
 */
public class CheckNumberPalindrome {

    public static void main(String args[]) {
        int num = 4554;
        System.out.println(checkPalNum(num));
    }

    private static boolean checkPalNum(int num) {
        if (num < 0) {
            return false;
        }

        if (num/10 == 0) {
            return true;
        }

        int count = 0;
        int temp = num;
        while(temp > 0) {
            temp = temp/10;
            ++count;
        }

        int mid = count/2;
        temp = 0;
        while (mid > 0) {
           temp = 10*temp + num%10;
            num = num/10;
           --mid;
        }

        if (count%2 == 0) {
            if (temp == num) {
                return true;
            }
        } else {
            num = num/10;
            if (temp == num) {
                return true;
            }
        }

        return false;
    }
}
