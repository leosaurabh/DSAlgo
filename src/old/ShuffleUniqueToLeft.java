/**
 * Created by ss030277 on 5/27/15.
 */
public class ShuffleUniqueToLeft {

    public static void main(String args[]) {
        char[] arr = new char[]{'1','1','1','2','2','4','5','5','6','6','8'};
        System.out.println(shuffle(arr));

        for (char x : arr) {
            System.out.print(x);
        }
    }

    private static int shuffle(char[] arr) {
        int length = arr.length;
        if (arr == null || length == 0) {
            return -1;
        }

        int index = 0;
        int trav = 1;
        char num = arr[index];

        while (trav < length) {
            if (num == arr[trav]) {
                arr[trav] = 'X';
                ++trav;
            } else {
                num = arr[trav];
                arr[trav] = 'X';
                arr[++index] = num;
                ++trav;
            }
        }
        return index;
    }
}
