import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ss030277 on 5/26/15.
 */
public class FindRout {

    public static void main(String args[]) {
        String[] arr = "B,A,Z,X,A,Z,D,B".split(",");
        getRoute(arr);
    }

    private static void getRoute(String[] arr) {
        if (arr == null) {
            return ;
        }

        int length = arr.length;
        if (length % 2 != 0) {
            return ;
        }

        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> revMap = new HashMap<String, String>();
        for (int i = 0; i < length - 1; i = i+2) {
            map.put(arr[i], arr[i+1]);
            revMap.put(arr[i+1], arr[i]);
        }

        String startStr = arr[0];
        boolean up = true;
        StringBuilder stringBuilder = new StringBuilder();
        while(!map.isEmpty()) {
            if (up) {
                String temp = revMap.get(startStr);
                if (temp != null) {
                    startStr = temp;
                } else {
                    up = false;
                }
            } else {
                String temp = map.get(startStr);
                if (stringBuilder.length() == 0) {
                    stringBuilder.append(startStr);
                }
                stringBuilder.append("->").append(temp);
                map.remove(startStr);
                startStr = temp;
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
