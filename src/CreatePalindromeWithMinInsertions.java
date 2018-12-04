import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Created by ss030277 on 5/17/15.
 */
public class CreatePalindromeWithMinInsertions {

    public static void main(String args[]) {
        Character arr[] = new Character[]{'y', 'k', 'a', 'a', 'k'};

        int i = 0;
        int length = arr.length;
        Map<Character, Integer> characterIntegerMap = new IdentityHashMap<Character, Integer>();

        while (i < length) {
            char ch = arr[i];
            Integer index = characterIntegerMap.get(ch);

            if (index == null) {
                characterIntegerMap.put(ch, i);
            } else {
                char temp = '\0';
                if (i > length/2) {
                    if (index < length/2) {
                        temp = arr[length - index -1];
                        arr[length - index - 1] = arr[i];
                        arr[i] = temp;
                        i = index;
                    } else if (index > length/2) {
                        temp = arr[length - index -1];
                        arr[length - index - 1] = arr[i];
                        arr[i] = temp;
                        i = length - index - 1;
                    } else {
                        temp = arr[length - i -1];
                        arr[length - i -1] = arr[index];
                        arr[index] = temp;
                        i = length - i -1;
                    }
                } else if (i < length/2) {
                    temp = arr[length - index - 1];
                    arr[length - index -1] = arr[i];
                    arr[i] = temp;
                    --i;
                }
                characterIntegerMap.remove(ch);
            }
            ++i;
        }

        for (char ch : arr) {
            System.out.print(ch);
        }
    }
}
