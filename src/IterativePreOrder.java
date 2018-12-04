/**
 * Created by ss030277 on 5/4/15.
 */
public class IterativePreOrder {

    public static void main(String args[]) {
        Node root = TreeOld.getTree();
        Stack stack = new Stack();
        stack.push(root);
        Node prev = null;
        int depth = 0;

        while(!stack.isEmpty()) {
            Node node = stack.peek();
            if (prev == null || prev.left == node || prev.right == node) {
                System.out.println(node.value);
                if (node.left != null) {
                    stack.push(node.left);
                } else if (node.right != null) {
                    stack.push(node.right);
                }
            } else if (node.left == prev) {
                if (node.right != null) {
                    stack.push(node.right);
                }
            } else {

                stack.pop();
            }
            prev = node;
            if (stack.getSize() > depth) {
                depth = stack.getSize();
            }
        }

        System.out.println(depth);
    }
}