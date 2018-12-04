/**
 * Created by ss030277 on 5/22/15.
 */
public class CompareVersions {

    public static void main(String args[]) {
        System.out.println(isSmaller("2.2.4", "2.2.4.4"));
    }

    private static boolean isSmaller(String first, String second) {
        if (first == null || first.isEmpty()) {
            return true;
        }

        if (second == null || second.isEmpty()) {
            return false;
        }

        String[] arr = first.split("\\.");
        String arr1[] = second.split("\\.");

        int count = arr.length >= arr1.length ? arr.length : arr1.length;

        boolean isSmall = true;
        int i = 0;

        while (i < count) {
            int num1 = count > arr.length ? 0 : Integer.parseInt(arr[i]);
            int num2 = count > arr1.length ? 0 : Integer.parseInt(arr1[i]);

            if (num1 > num2) {
                isSmall = false;
                break;
            } else if (num1 < num2) {
                break;
            }
            ++i;
        }

        return isSmall;
    }
}
