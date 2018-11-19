/**
 * Created by ss030277 on 5/6/15.
 */
public class BracketsValidNumberAndOrder {

    public static void main(String args[]) {
        String input = "e[r{12(%^{56})$^}mk]l";
        System.out.println(checkStr(input));
    }

    private static boolean checkStr(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        Stack stack = new Stack();

        for (char ch : str.toCharArray()) {
            if (isValidChar(ch)) {
                if (pushable(ch)) {
                    stack.push(getNode(ch));
                } else {
                    Node node = stack.peek();

                    if (ch == ')' && node.ch == '(') {
                        stack.pop();
                    } else if (ch == '}' && node.ch == '{') {
                        stack.pop();
                    } else if (ch == ']' && node.ch == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    private static Node getNode(char ch) {
        return new Node(ch);
    }

    private static boolean isValidChar(char ch) {
        if (ch == '[' || ch == '{' || ch == '(' || ch == ')' || ch == '}' || ch == ']' ) {
            return true;
        }
        return false;
    }

    private static boolean pushable(char ch) {
        if (ch == '[' || ch == '{' || ch == '(') {
            return true;
        }
        return false;
    }
}
