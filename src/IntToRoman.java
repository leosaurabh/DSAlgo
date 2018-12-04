import java.util.*;

public class IntToRoman {

    private static Map<Integer, String> map = new LinkedHashMap<Integer, String>() {
        {
            put(1, "I");
            put(5, "V");
            put(10, "X");
            put(50, "L");
            put(100, "C");
            put(500, "D");
            put(1000, "M");
        }
    };

    public static void main(String args[]) {
        System.out.println(intToRoman(999));
    }

    private static String intToRoman(int num) {
        if (num <= 0 || num > 3999) {
            return "";
        }

        int ct = 0;
        while ((num/(int) Math.pow(10, ++ct)) != 0);
        int factor = (int) Math.pow(10, ct-1);

        StringBuilder build = new StringBuilder();
        LinkedList<Integer> keys = new LinkedList<Integer>(map.keySet());
        int start = 0;
        int end = 0;
        for (int i = 0; i < keys.size(); i++) {
            if (num/keys.get(i) == 0) {
                start = keys.get(i - 1);
                end = keys.get(i);
                break;
            }
        }
        if (start == 0 && end == 0) {
            start = 1000;
            end = 4000;
        }

        convert(start, end, factor, num, build);
        return build.toString();
    }

    private static void convert(int start, int end, int factor, int num, StringBuilder build) {
        if (end - num <= factor) {
            int overflow = factor - end + num;
            if (overflow != 0)
                build.append(map.get(factor)).append(map.get(end)).append(intToRoman(overflow));
            else
                build.append(map.get(factor)).append(map.get(end));
        } else {
            int overflow = num - start;
            if (overflow != 0)
                build.append(map.get(start)).append(intToRoman(overflow));
            else
                build.append(map.get(start));
        }
    }
}
