/**
 * Created by ss030277 on 5/7/15.
 */
public class MergeThreeSortedArrays {

    public static void main(String args[]) {
        Integer arr1[] = {1,4,5,6};
        Integer arr2[] = {3,6};
        Integer arr3[] = {2,5,8};
        Integer finalArr[] = merge(arr1, arr2, arr3);

        for (int num : finalArr) {
            System.out.println(num);
        }
    }

    private static Integer[] merge(Integer[] arr1, Integer[] arr2, Integer[] arr3) {
        if (arr1 == null || arr2 == null || arr3 == null){
            return new Integer[0];
        }

        int length1 = arr1.length;
        int length2 = arr2.length;
        int length3 = arr3.length;
        int length4 = length1+length2+length3;

        if (length1 == 0 || length2 == 0 || length3 == 0) {
            return new Integer[0];
        }

        Integer finalArr[] = new Integer[length4];

        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;

        while ((i < length1 || j < length2 || k < length3) && l<length4) {
            if (i>length1-1) {
                if (j>length2-1) {
                    finalArr[l] = arr3[k];
                    ++k;
                } else if (k>length3-1) {
                    finalArr[l] = arr2[j];
                    ++j;
                } else if (arr2[j] <= arr3[k]) {
                    finalArr[l] = arr2[j];
                    ++j;
                } else {
                    finalArr[l] = arr3[k];
                    ++k;
                }
            } else if (j>length2-1) {
                if (k>length3-1) {
                    finalArr[l] = arr1[i];
                    ++i;
                } else if (arr1[i] <= arr3[k]) {
                    finalArr[l] = arr1[i];
                    ++i;
                } else {
                    finalArr[l] = arr3[k];
                    ++k;
                }
            } else if (k>length3-1) {
                if (arr1[i] <= arr2[j]) {
                    finalArr[l] = arr1[i];
                    ++i;
                } else {
                    finalArr[l] = arr1[j];
                    ++j;
                }
            } else {
                if (arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) {
                    finalArr[l] = arr1[i];
                    ++i;
                } else if (arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) {
                    finalArr[l] = arr2[j];
                    ++j;
                } else if (arr3[k] <= arr1[i] && arr3[k] <= arr2[j]) {
                    finalArr[l] = arr3[k];
                    ++k;
                }
            }
            ++l;
        }

        return finalArr;
    }
}
