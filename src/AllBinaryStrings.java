import java.util.LinkedList;
import java.util.List;

public class AllBinaryStrings {

    public static void main(String[] args) {
        allBinary("1??0?101");
    }
    // 1??
    public static  void allBinary(String str) {
        List<Integer> indices = new LinkedList<>();
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '?') {
                indices.add(i);
            }
        } // indices -> 1,2
        all(str.toCharArray(), indices, -1, '\0');
    }

    private static void all(char[] arr, List<Integer> indices, int i, char ch) {
        if (i >= 0) {
            arr[indices.get(i)] = ch;
            if (i == indices.size() - 1) {
                System.out.println(new String(arr));
                return;
            }
        }

        all(arr, indices, i + 1, '0');
        all(arr, indices, i + 1, '1');
    }
}
