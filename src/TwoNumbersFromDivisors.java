//Given an array of N numbers which has all divisors of two numbers in any order. The task is to find the two numbers whose divisors are given in the array.
//
//        Examples:
//
//        Input: a[] = {10, 2, 8, 1, 2, 4, 1, 20, 4, 5}
//        Output: 20 8
//        The divisors of 20 and 8 are given in the array.
//
//        Input: a[] = {2, 2, 1, 1}
//        Output: 1 2

import java.util.HashMap;

public class TwoNumbersFromDivisors {

    public static void main(String[] args) {
        int[] res = findNumbers(new int[]{10, 2, 5, 1, 20, 10, 2, 1, 4, 5});
        System.out.println();
    }

    public static int[] findNumbers(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        HashMap<Integer, Integer> countByDivisor = new HashMap<Integer, Integer>();
        int max = Integer.MIN_VALUE;
        for (int num : a) max = num > max ? num : max;

        for (int num : a) {
            if (max % num == 0) {
                if (!countByDivisor.containsKey(num)) {
                    countByDivisor.put(num, 1);
                } else {
                    countByDivisor.put(num, countByDivisor.get(num) + 1);
                }
            }
        }

        int max1 = Integer.MIN_VALUE;
        for (int num : a) {
            if (countByDivisor.containsKey(num)) {
                if (countByDivisor.get(num) > 1) {
                    max1 = num > max1 ? num : max1;
                }
            } else {
                max1 = num > max1 ? num : max1;
            }
        }
        return new int[] {max, max1};
    }
}
