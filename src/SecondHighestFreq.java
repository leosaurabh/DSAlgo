/**
 * Created by ss030277 on 5/7/15.
 */
public class SecondHighestFreq {

    public static void main(String args[]) {
        String str = "aaaabbbccd";

        char chOne = '\0';
        char chTwo = '\0';
        int countOne = -1;
        int countTwo = -1;

        int count = 1;
        char arr[] = str.toCharArray();
        int length = arr.length;

        for (int i = 0; i < length-1; i++) {
           if (arr[i] == arr[i+1]) {
               ++count;
           } else {
               if (count > countOne) {
                   chTwo = chOne;
                   chOne = arr[i];
                   countTwo = countOne;
                   countOne = count;
               } else if (count > countTwo) {
                   countTwo = count;
                   chTwo = arr[i];
               }
               count = 1;
           }
        }
        System.out.println(chOne);
        System.out.println(chTwo);
        System.out.println(countOne);
        System.out.println(countTwo);

    }
}
