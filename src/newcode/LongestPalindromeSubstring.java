package newcode;

import java.util.ArrayList;

class LongestPalindromeSubstring {

    public static void main(String args[]) {
        System.out.println(longestPalindrome("a3rdvdr312"));
    }

    private static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int length = 0;
        StringBuffer result = new StringBuffer();
        ArrayList<Character> traversed = new ArrayList<Character>();
        boolean found = false;
        int foundIndex = -1;
        int count = 0;

        for (int i = 0; i < s.length(); i++ ) {
            char c = s.charAt(i);
            if (traversed.isEmpty()) {
                traversed.add(c);
            } else {
                if (!found) {
                    if (c == traversed.get(traversed.size() - 1)) {
                        foundIndex = traversed.size() - 1;
                        found = true;
                        ++count;
                    } else if (traversed.size() >= 2 && c == traversed.get(traversed.size() - 2)) {
                        foundIndex = traversed.size() - 2;
                        found = true;
                        ++count;
                    }
                    traversed.add(c);
                } else {
                    if (foundIndex == 0) {
                        if (count > length) {
                            length = count;
                            result.setLength(0);
                            result.append(s.substring(0, i));
                        }
                        count = 0;
                        found = false;
                        i--;
                    } else if (c != traversed.get(--foundIndex)) {
                        if (count > length) {
                            length = count;
                            result.setLength(0);
                            result.append(s.substring(++foundIndex, i));
                        }
                        count = 0;
                        found = false;
                        i--;
                    } else {
                        ++count;
                    }
                }
            }
        }

        return result.toString();
    }
}