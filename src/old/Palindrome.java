class Palindrome {

    public static void main(String args[]) {
        String str = "Red rum, sir, is murder";
        str = str.toUpperCase();
        System.out.println(isPalindrome(str));
    }

    private static boolean isPalindrome(String str)	 {
        if (str == null || str.isEmpty()) {
            return false;
        }

        char ch[] = str.toCharArray();
        int length = ch.length;

        if (length < 2) {
            return true;
        }

        int i = 0;
        int j = length - 1;

        while (i < j) {
            if (ch[i] < '0' || (ch[i] > '9' && ch[i] < 'A') || ch[i] > 'Z') {
                ++i;
            } else if (ch[j] < '0' || (ch[j] > '9' && ch[j] < 'A') || ch[j] > 'Z') {
                --j;
            } else {
                if(ch[i] == ch[j]) {
                    ++i;
                    --j;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}