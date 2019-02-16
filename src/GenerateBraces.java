import java.util.ArrayList;
import java.util.List;

public class GenerateBraces {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }

        populate(ans, n, 0, 0, "");
        return ans;
    }

    private void populate(List<String> ans, int n, int start, int end, String str) {
        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }

        if (start < n) {
            populate(ans, n, start + 1, end, str + "(");
        }
        if (end < start) {
            populate(ans, n, start, end + 1, str + ")");
        }
    }
}
