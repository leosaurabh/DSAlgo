public class Trie {

    char ch;
    Trie[] children;
    boolean isLeaf;
    int wordCount;

    Trie(char ch) {
        this.ch = ch;
        this.children = new Trie[26];
        this.wordCount = 0;
    }

    public static void main(String[] args) {
        Trie root = new Trie('\0');
        insert(root, "test");
        System.out.println();
    }

    static void insert(Trie root, String word) {
        for (int i =0; i< word.length(); i++) {
            char ch = word.charAt(i);
            if (root.ch == '\0') {
                root.ch = ch;
            } else {
                Trie temp = new Trie(ch);
                root.children[ch - 'a'] = temp;
                root = temp;
            }
            if (i ==  (word.length() - 1)) {
                root.isLeaf = true;
                root.wordCount += 1;
            }
        }
    }
}
