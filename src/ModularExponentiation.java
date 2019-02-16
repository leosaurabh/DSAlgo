public class ModularExponentiation {

    // Calculate pow(x, y) % p

    // log(y) solution
    public int calculate(int x, int y) {
        int res = 1;
        while (y > 0) {

            // Check if y is odd, last bid is 1
            if ((y & 1) == 1) {
                res = res * x;
            }
            // At each step we consume 2 x so as to finish computation in half time
            x = x*x;
            // Halving the number of times we multiple x.
            y = y/2;
        }
        return res;
    }
}
