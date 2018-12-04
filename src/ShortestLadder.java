import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ss030277 on 5/5/15.
 */
public class ShortestLadder {

    public static void main(String args[]) {
        String start = "hit";
        String end = "cog";
//        List<String> words = Arrays.asList(new String[]{"hot","dot","dog","lot","log"});
        List<String> words = new LinkedList<String>();
        words.add("hot");
        words.add("dot");
        words.add("dog");
        words.add("lot");
        words.add("log");

        int count = 0;
        boolean tempMatchFound = false;
        boolean permMatchFound = false;

        while(!permMatchFound && !words.isEmpty()) {
            char startArr[] = start.toCharArray();
            int length = start.length();
            for (int i = 0; i <length; i++) {

                char prev = startArr[i];
                for (char ch = 'a'; ch <= 'z'; ch++ ) {
                    startArr[i] = ch;

                    String newStr = String.valueOf(startArr);
                    if (newStr.equalsIgnoreCase(end)) {
                        System.out.println("reached end");
                        permMatchFound = true;
                        tempMatchFound = true;
                        break;
                    }

                    if (words.remove(newStr)) {
                        ++count;
                        start = newStr;
                        tempMatchFound = true;
                        break;
                    } else {
                        startArr[i] = prev;
                    }
                }
                if (tempMatchFound) {
                    tempMatchFound = false;
                    break;
                }
            }
        }

        if (!start.equalsIgnoreCase(end)) {
            count = -1;
        }
        System.out.println(count);
    }
}
