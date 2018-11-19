/**
 * Created by ss030277 on 5/3/15.
 */
public class PerfectSquare {

    public static void main(String args[]) {
        double x = sqRoot(26);
        int y = (int) x;

        if (x - y <= 0) {
            System.out.println("PS");
        }
    }

    private static double sqRoot(double num) {
        double x = num;
        double y = 1.00;
        double e = 0.000000000001;

        while(x-y > e) {
            x = (x+y)/2;
            y = num/x;
        }

        return x;
    }
}
