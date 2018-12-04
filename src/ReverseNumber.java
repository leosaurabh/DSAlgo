

public class ReverseNumber {

    public int reverse(int x) {
        if (x/10 == 0) {
            return x;
        }

        boolean isNegative = x < 0;
        int rev = 0;
        while(x != 0) {
            rev = 10 * rev + x % 10;
            x = x/10;
        }
        return isNegative ? -1 * rev : rev;
    }
}
