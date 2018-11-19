/**
 * Created by Saurabh Sinha on 5/14/15.
 */
public class HashExercise {

    private static final String ERROR_IN_HASHING = "Input string could not be un hashed";
    private static final String ERROR_INPUT_HASH = "Invalid hash data";
    private static final String ERROR_LETTERS_NULL = "Null input letters";
    private static final String ERROR_LETTERS_EMPTY = "Input letters empty";

    private static final int DIV_FACTOR = 37;

    public static void main(String args[]) {
        long hash = 932246728227799l;
        String letters = "acegikmnoprstuvy";

        String result = returnUnhashedString(hash, letters);

        System.out.println(result);
    }

    private static String returnUnhashedString (long hash, final String letters) {
        if (hash < 0) {
           return ERROR_INPUT_HASH + " > " + hash;
        }

        if (letters == null) {
            return ERROR_LETTERS_NULL + " > " + letters;
        }

        if (letters.isEmpty()) {
            return ERROR_LETTERS_EMPTY + " > " + letters;
        }

        StringBuffer result = new StringBuffer();

        int length = letters.length();
        int count = 0;

        while (hash > 0 && count < length) {
            if ((hash - count) % DIV_FACTOR == 0) {
                hash = (hash - count)/DIV_FACTOR;
                if (hash > 0) {
                    result.append(letters.charAt(count));
                }
                count = 0;
            } else {
                ++count;
            }
        }

        if (hash == 0) {
            return result.reverse().toString();
        } else {
            return ERROR_IN_HASHING;
        }
    }
}
