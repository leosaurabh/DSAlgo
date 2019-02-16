

public class TwoNonRepeatingIntegers {

    // From an Array of integers, find the two non repeating integers
    public void printNonRepeatingNumbers(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int xor = xored(arr);

        int rightMostSetBit = xor & ~(xor - 1);

        int xor1 = 0;
        int xor2 = 0;
        for (int i : arr) {
            int temp = (arr[i] >> rightMostSetBit) & 1;
            if (temp == 1)
                xor1 ^= i;
            else
                xor2 ^= i;
        }
        System.out.println(xor1 + " " + xor2);
    }

    private int xored(int[] arr) {
        int xor = arr[0];
        for (int i = 1; i<arr.length; i++) {
            xor = xor ^ arr[i];
        }
        return xor;
    }
}
