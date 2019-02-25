/**
 * Created by ss030277 on 5/15/15.
 */
public class RemoveDuplicatesAndCountUnique {

    public static void main(String args[]) {
//        Integer arr[] = new Integer[]{-1,-1,-1,2,3,3,4,4,5};
//        System.out.println("\n" + countUnique(arr));

        System.out.println(removeDup(new int[] {1,1,1,2,2,3,4,4,4,4,6}));
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

    private static int removeDup(int[] arr) {
        int i = 0;
        int j = 1;
        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                if (i == 0) {
                    i++;
                    j++;
                } else if (arr[i] == arr[i-1]) {
                    j++;
                } else {
                    i++;
                    arr[i] = arr[j];
                    j++;
                }
            } else {
                i++;
                arr[i] = arr[j];
                j++;
            }
        }
        System.out.println(arr);
        return i+1;
    }
}
