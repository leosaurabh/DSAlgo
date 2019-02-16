import java.util.ArrayList;
import java.util.List;


//You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
//
//        Example 1:
//
//        Input:
//        s = "barfoothefoobarman",
//        words = ["foo","bar"]
//        Output: [0,9]
//        Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
//        The output order does not matter, returning [9,0] is fine too.
//        Example 2:
//
//        Input:
//        s = "wordgoodgoodgoodbestword",
//        words = ["word","good","best","word"]
//        Output: []

public class SubstringOfAllPermutations {

    public List<Integer> findSubstring(String s, String[] words) {
        if (words == null || words.length == 0 || s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<Integer> indexes = new ArrayList<Integer>();
        addIndex(indexes, 0, words, s);
        return indexes;
    }

    private void addIndex(List<Integer> indexes, int start, String[] words, String s) {
        if (start >= words.length) {
            String concat = concatenate(words);
            if (s.indexOf(concat) >= 0) {
                indexes.add(s.indexOf(concat));
            }
        }

        for (int i = start; i<words.length; i++) {
            swap(words, i, start);
            addIndex(indexes, start + 1, words, s);
            swap(words, i, start);
        }
    }

    private String concatenate(String[] words) {
        StringBuilder build = new StringBuilder();
        for (String word : words) {
            build.append(word);
        }
        return build.toString();
    }

    private void swap(String[] words, int i, int j) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
}
