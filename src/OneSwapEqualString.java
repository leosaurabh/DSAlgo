public class OneSwapEqualString {

    public boolean check(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        int l1 = str1.length();
        int l2 = str2.length();
        if (l1 == 0 || l2 == 0 || l1 != l2) {
            return false;
        }

        int s1 = 0, s2 = 0;
        int e1 = l1-1, e2 = l2-1;
        int count = 0;

        while(s1 < e1) {
            if (str1.charAt(s1) == str2.charAt(s2)) {
                s1++;
                s2++;
            } else {
                if (str1.charAt(e1) == str2.charAt(e2)) {
                    e1--;
                    e2--;
                } else {
                    if (str1.charAt(s1) == str2.charAt(e2) && str2.charAt(s2) == str1.charAt(e1)) {
                        ++count;
                        s1++;
                        s2++;
                        e1--;
                        e2--;
                    } else {
                        return false;
                    }
                }
            }
        }

        return count == 1;
    }
}
