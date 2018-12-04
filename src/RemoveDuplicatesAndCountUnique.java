/**
 * Created by ss030277 on 5/15/15.
 */
public class RemoveDuplicatesAndCountUnique {

    public static void main(String args[]) {
        Integer arr[] = new Integer[]{-1,-1,-1,2,3,3,4,4,5};
        System.out.println("\n" + countUnique(arr));
    }

    private static int countUnique(Integer arr[]) {
        int length = 0;

        if (arr == null || (length = arr.length) == 0) {
            throw new IllegalArgumentException("Invalid array");
        }

        int i = 1;
        int count = 1;
        int temp = arr[0];

        System.out.print(temp + " ");

        while (i < length) {
            if (temp != arr[i]) {
                temp = arr[i];
                System.out.print(temp + " ");
                ++count;
            }
            ++i;
        }
        return count;
    }
}
