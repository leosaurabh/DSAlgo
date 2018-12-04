

import java.util.HashSet;
import java.util.Set;

class LongestNonRepeatingSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int length = 0;
        int count = 0;
        Set<Character> sub = new HashSet<>();

        for (char c: s.toCharArray()) {
            if (count == 0) {
                sub.add(c);
                count++;
            } else {
                if (sub.contains(c)) {
                    if (sub.size() > length) {
                        length = sub.size();
                    }
                    count = 0;
                    sub.clear();
                }
                sub.add(c);
            }
        }
        return length;
    }
}