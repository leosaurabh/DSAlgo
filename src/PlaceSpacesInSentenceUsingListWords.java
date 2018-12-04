/**
 * Created by ss030277 on 5/5/15.
 */
public class PlaceSpacesInSentenceUsingListWords {

    public static void main(String args[]) {
        String inp = "HiIamSaurabh";
        String words[] = {"Hi", "I", "am", "Saurabh"};

        String temp = "";
        StringBuilder output = new StringBuilder();
        for (char ch : inp.toCharArray()) {
            if (ch == '\0') {
                continue;
            }
            temp = temp + ch;
            if (ifExists(temp, words)) {
                output.append(temp).append(" ");
                temp = "";
            }
        }
        System.out.println(output.toString());
    }

    private static boolean ifExists(String str, String words[]) {
        if (str == null || words == null || words.length == 0) {
            return false;
        }

        for (String word : words) {
            if (word.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
