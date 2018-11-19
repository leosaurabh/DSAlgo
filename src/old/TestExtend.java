/**
 * Created by ss030277 on 4/20/15.
 */
public class TestExtend {

    public static void main(String args[]) {
        Test test = new Test();
        System.out.println(test.getX());

        String xx = test.getX();
        xx.concat("b");

        System.out.println(xx);
        System.out.println(test.getX());
    }
}
