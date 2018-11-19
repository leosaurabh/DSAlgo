/**
 * Created by ss030277 on 5/4/15.
 */
public class DFS {

    public static void main(String args[]) {
        Stack stack = new Stack();
        Node root = Tree.getTree();
        int toFind = 4;

        if (root.value == toFind) {
            System.out.println("found->" + root);
        } else {
            stack.push(root);
        }

        Node node = null;
        while (!stack.isEmpty()) {
            if (stack.peek() != null) {
                node = stack.pop();

                if (node.value == toFind) {
                    System.out.println("found->" + node.value);
                    break;
                } else {
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }
            } else {
                stack.pop();
            }
        }

    }
}
