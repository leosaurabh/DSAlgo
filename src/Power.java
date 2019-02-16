public class Power {

    // pow (x, y)
    int power(int x, int y)
    {
        int temp;
        if( y == 0)
            return 1;
        temp = power(x, y/2);
        if (y%2 == 0)
            return temp*temp;
        else
            return x*temp*temp;
    }

    int powerIter(int x, int y) {
        int res = 1;     // Initialize result

        while (y > 0)
        {
            // If y is odd, multiply x with result
            if ((y & 1) == 1)
                res = res*x;

            // n must be even now
            y = y>>1; // y = y/2
            x = x*x;  // Change x to x^2
        }
        return res;
    }
}
