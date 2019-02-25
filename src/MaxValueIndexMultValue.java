//Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed
//
//Given an array, only rotation operation is allowed on array. We can rotate the array as many times as we want.
//Return the maximum possbile of summation of i*arr[i].
//
//Rj - Rj-1 = arrSum - n * arr[n-j]

public class MaxValueIndexMultValue {

    public static void main(String[] args) {
        System.out.println(maxSum(new int[] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    public static int maxSum(int[] arr) {
        if (arr == null) {
            return -1;
        }

        int length = arr.length;
        if (length == 0) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int arrSum = 0;
        int baseSum = 0;
        for (int i =0; i<length; i++) {
            arrSum += arr[i];
            baseSum += i*arr[i];
        }

        int sum = baseSum;
        for (int i =1; i<length; i++) {
            sum += arrSum - length*arr[length - i];
            max = sum > max ? sum : max;
        }

        return max;
    }
}
