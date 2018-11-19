import org.joda.time.Instant;

/**
 * Created by ss030277 on 4/17/15.
 */
public class Test {

    public static void main(String args[]) {
        int num = 3;
        int x = num & ~(num >> 1);
        System.out.println(x);

        char ch = 'a';
    }

    private String x = "a";

    protected String getX() {
        return this.x;
    }
}
