/**
 * Created by ss030277 on 5/4/15.
 */
public class ReversePolishOrPostFixExpression {

    public static void main(String args[]) {
        String expr = "19,2,36,+,/";
        String arr[] = expr.split(",");
        Stack stack = new Stack();

        for (String ch: arr) {
            if (!ch.equalsIgnoreCase("-") && !ch.equalsIgnoreCase("+") && !ch.equalsIgnoreCase("*") &&
                    !ch.equalsIgnoreCase("/")) {
                stack.push(new Node(Integer.parseInt(ch)));
            } else {
                Node a = stack.pop();
                if (a == null) {
                    System.out.println("Error");
                    break;
                }
                Node b = stack.pop();
                if (b == null) {
                    System.out.println("Error");
                    break;
                }

                if (ch.equalsIgnoreCase("+")) {
                    stack.push(new Node(a.value + b.value));
                } else if (ch.equalsIgnoreCase("-")) {
                    stack.push(new Node(a.value - b.value));
                } else if (ch.equalsIgnoreCase("*")) {
                    stack.push(new Node(a.value * b.value));
                } else if (ch.equalsIgnoreCase("/")) {
                    stack.push(new Node(a.value / b.value));
                }
            }

        }
        System.out.println(stack.peek().value);
    }
}
