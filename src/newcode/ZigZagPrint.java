package newcode;

import java.util.ArrayList;
import java.util.List;

public class ZigZagPrint {

    public static void main(String args[]) {
        zigZag("EBAYISEVERYTHING", 3);
    }

    private static String zigZag(String inp, int rows) {
        if (inp == null || inp.isEmpty() || rows <= 0) {
            return inp;
        }

        List<StringBuilder> list = new ArrayList<>();
        int ct = 0;
        boolean down = true;

        for (int i=0; i < inp.length(); i++) {
            if ((list.size() -  1) < ct) {
                list.add(new StringBuilder());
            }
            if (down) {
                if (ct < rows) {
                    list.get(ct).append(inp.charAt(i));
                    ct++;
                } else {
                    down = false;
                    ct -= 2;
                    i--;
                }
            } else {
                if (ct >= 0) {
                    list.get(ct).append(inp.charAt(i));
                    ct--;
                } else {
                    down = true;
                    ct += 2;
                    i--;
                }
            }
        }
        StringBuilder build = new StringBuilder();
        for (StringBuilder str: list) {
            build.append(str);
        }
        return build.toString();
    }
}
