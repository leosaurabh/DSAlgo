package newcode;

public class RegularExpressionMatching {

    public static void main(String args[]) {
        System.out.println(isMatch("mississippi", "mis*is*p*."));
    }

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        if (s.equals(p)) {
            return true;
        }

        if (p.trim().length() == 0) {
            return false;
        }


        if (p.equals("*")) {
            return true;
        }

        if (s.trim().length() == 0) {
            return false;
        }

        if (p.equals(".*")) {
            return true;
        }

        if (!p.contains("*") && s.length() > p.length()) {
            return false;
        }

        // .,*,*.,.*
        int sc = 0;
        int pc = 0;
        boolean encountered = false;
        char repeat = '\0';

        while (sc < s.length() && pc < p.length()) {
            if (s.charAt(sc) == p.charAt(pc) || p.charAt(pc) == '.') {
                sc++;
                pc++;
            } else if ((pc + 1 < p.length()) && p.charAt(pc + 1) == '*') {
                pc += 2;
            } else if (p.charAt(pc) == '*') {
                if (encountered) {
                    if (s.charAt(sc) == repeat) {
                        sc++;
                    } else {
                        pc++;
                        encountered = false;
                    }
                } else {
                    if (p.charAt(pc - 1) == s.charAt(sc)) {
                        repeat = p.charAt(pc - 1);
                        encountered = true;
                        sc++;
                    } else {
                        sc++;
                        pc++;
                    }

                }
            } else {
                return false;
            }
        }
        return (pc >= p.length() - 1 && sc >= s.length() - 1) ;
    }
}
