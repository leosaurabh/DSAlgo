/**
 * Created by ss030277 on 5/18/15.
 */
public class ReplaceNumWithAllButOwnProduct {

    public static void main(String args[]) {
        Integer arr[] = new Integer[]{3,4,1,2,5};

        int length = arr.length;
        Integer newArr[] = new Integer[length];

        int tempPrd = 1;

        for (int num = 0; num < length; num++) {
            newArr[num] = arr[num] * tempPrd;
            tempPrd = newArr[num];
        }

        for (int no : newArr) {
            System.out.print(no + " ");
        }
        System.out.println();
        tempPrd = 1;
        for(int j = length-1; j>=0; --j) {
            if (j == 0) {
                arr[j] = tempPrd;
            } else {
                int temp = arr[j];
                arr[j] = newArr[j - 1] * tempPrd;
                tempPrd *= temp;
            }
        }

        for (int no : arr) {
            System.out.print(no + " ");
        }
    }
}
