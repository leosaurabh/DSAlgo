import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneToLetterCombination {

    private static Map<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ijk");
            put('5', "lmn");
            put('6', "opq");
            put('7', "rst");
            put('8', "uvw");
            put('9', "xyz");
        }
    };

    public static void main(String args[]) {
        List<String> combinations = letterCombinations("234");
        System.out.println( );
    }

    private static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return null;
        }

        List<String> strings = new ArrayList<>();
        for (char c: digits.toCharArray()) {
            strings.add(map.get(c));
        }

        List<String> combinations = new ArrayList<>();
        populate(strings, combinations, 0, new StringBuilder());
        return combinations;
    }

    private static void populate(List<String> strings, List<String> combinations, int index, StringBuilder build) {
        String str = strings.get(index);
        for (char c : str.toCharArray()) {
            build.append(c);
            if (build.toString().length() == strings.size()) {
                combinations.add(build.toString());
            } else {
                if (index + 1 < strings.size()) {
                    populate(strings, combinations, index + 1, build);
                }
            }
            build.deleteCharAt(build.toString().length() - 1);
        }
    }
}
