/**
 * Created by ss030277 on 5/4/15.
 */
public class InOrderIterative {
    public static void main(String args[]) {
        Node root = Tree.getTree();
        Stack stack = new Stack();
        Node current = root;
        int depth = 0;

        while(!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.println(current.value);
                current = current.right;
            }
            if (stack.getSize() > depth) {
                depth = stack.getSize();
            }
        }

        System.out.println(depth);
    }
}