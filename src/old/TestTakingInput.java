import java.util.Scanner;

/**
 * Created by ss030277 on 5/21/15.
 */
public class TestTakingInput {

    public static void main(String args[]) {
        int num = 0;

        while (num != 42) {
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
        }
    }
}
