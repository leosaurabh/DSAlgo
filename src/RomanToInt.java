import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToInt {

    private static Map<Character, Integer> map = new LinkedHashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public static void main(String args[]) {
        System.out.println(convert("XLI"));
    }
    
    private static int convert(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException();
        }
        
        int result = 0;
        boolean down = true;
        char prev = '\0';
        for (char c : roman.toCharArray()) {
            if (map.get(prev) != null) {
                down = map.get(c) <= map.get(prev);
            }
            if (down) {
               result += map.get(c);
            } else {
                result = map.get(c) - result;
            }
            prev = c;
        }
        return result;
    }
}
