
//Implement strStr().
//Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.

public class StrStr {

    public static void main(String args[]) {
        String input = "qweqwerty";
        String needle = "wer";
        System.out.println(getPointer(input, needle));
    }

    private static int getPointer(String input, String needle) {
        if (input == null || needle == null) {
            return -1;
        }

        int needleLength = needle.length();
        int inputLength = input.length();

        if (needleLength == 0 || inputLength == 0 || needleLength == inputLength) {
            return 0;
        }

        if (needleLength > inputLength) {
            return -1;
        }

        for (int i = 0; i < inputLength; i++) {
            int j = i + needleLength - 1;

            if (j < inputLength) {

                int k = 0;
                int l = needleLength - 1;
                while (j >= i) {
                    if (input.charAt(j) == needle.charAt(l) && input.charAt(i) == needle.charAt(k)) {
                        ++i;
                        --j;
                        ++k;
                        --l;
                    } else {
                        break;
                    }
                    if (j <= i) {
                        return i - 1;
                    }
                }
            } else {
                return -1;
            }
        }
        return -1;
    }
}
