/**
 * Created by ss030277 on 5/30/15.
 */
public class LeftShift {

    public static void main(String args[]) {
        System.out.println(leftShift(3, 2));
    }

    private static int leftShift(int num, int count) {
        if (count <= 0) {
            return num;
        }

        Stack binary = new Stack();

        while (count > 0) {
            binary.push(new Node(0));
            --count;
        }

        while(num > 0) {
            binary.push(new Node(num % 2));
            num /= 2;
        }

        int finNumber = 0;
        while (!binary.isEmpty()) {
            finNumber = 2*finNumber + binary.pop().value;
        }

        return finNumber;
    }
}
