import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ss030277 on 5/16/15.
 */
public class CreatePalindromeFromString {

    public static void main(String args[]) {
        String str = "kakak";  // kyaka

        Map<Character, Integer> characterIntegerMap = new HashMap<Character, Integer>();
        populateCharMap(characterIntegerMap, str);
        createPalindrome(characterIntegerMap, str.length());
    }

    private static void populateCharMap(Map<Character, Integer> characterIntegerMap, String str) {
        if (characterIntegerMap == null || str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }

        for (char ch : str.toCharArray()) {
            Integer temp = characterIntegerMap.get(ch);

            if (temp == null) {
                characterIntegerMap.put(ch, 1);
            } else {
                characterIntegerMap.put(ch, temp + 1);
            }

        }
    }

    private static void createPalindrome(Map<Character, Integer> characterIntegerMap, int length) {
        Character arr[] = new Character[length];

        int arrCount = 0;
        Set<Character> chars = characterIntegerMap.keySet();

        for (char ch : chars) {
            int count = characterIntegerMap.get(ch);

            if (count % 2 == 0) {
                int temp = count/2;

                while (temp > 0) {
                    arr[arrCount] = ch;
                    arr[length - arrCount - 1] = ch;
                    ++arrCount;
                    --temp;
                }
            } else if (count == 1) {
                arr[length/2] = ch;
            } else {
                throw new IllegalArgumentException("Unable to create palindrome.");
            }
        }

        for (char ch : arr) {
            System.out.print(ch);
        }
    }
}
