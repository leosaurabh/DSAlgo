import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public List<List<String>> group(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        Integer[] arr = new Integer[26];
        StringBuilder build = new StringBuilder();

        for (String st : strs) {
            String str = st.toLowerCase();

            for (char c: str.toCharArray()) {
                int index = c - 'a';
                if (arr[index] == null) {
                    arr[index] = 1;
                } else {
                    ++arr[index];
                }
            }

            for (int i=0; i<26; i++) {
                build.append((char) (i + (int) 'a')).append(arr[i]);
                arr[i] = 0;
            }

            String key = build.toString();
            if (map.containsKey(key)) {
                map.get(key).add(st);
            } else {
                map.put(key, new ArrayList<String>() { {add(st);} });
            }
            build.setLength(0);
        }

        return new ArrayList<>(map.values());
    }
}
