// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.

class LongestRun {
    public static void main(String args[]) {
        String str = "aabbbccd";
        System.out.println(getLongestSeq(str));
        System.out.println(getOffsets(str.toCharArray()));
    }

    private static String getLongestSeq(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        int length = str.length();

        int tempCount = 1;
        int finalCount = Integer.MIN_VALUE;

        char[] arr = str.toCharArray();
        char lastCh = arr[0];

        StringBuilder strB = new StringBuilder(lastCh);
        String finalStr = "";


        for (int i = 1; i < length; i++) {
            if (lastCh != arr[i]) {
                if (tempCount > finalCount) {
                    finalCount = tempCount;
                    finalStr = strB.toString();
                    tempCount = 0;
                }
                strB.setLength(0);
            }
            lastCh = arr[i];
            strB.append(arr[i]);
            ++tempCount;
        }


        return finalStr;
    }

    private static String getOffsets(char[] str) {
        if (str == null || str.length == 0) {
            return "";
        }

        int count = 0;
        int index = 0;
        int length = str.length;
        int lastCh = str[0];

        StringBuilder strB = new StringBuilder();

        for (int i = 0; i < length; i++) {

            if (str[i] == lastCh) {
                ++count;
            } else {
                lastCh = str[i];
                if (count > 1) {
                    if (strB.length() != 0) {
                        strB.append(",");
                    }
                    strB.append(index);
                }
                index = i;
                count = 1;
            }
        }
        return strB.toString();
    }
}