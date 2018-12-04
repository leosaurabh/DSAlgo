/**
 * Created by ss030277 on 5/27/15.
 */
public class CheckBST {

    public static void main(String args[]) {
        Node root = TreeOld.getTree();

        Stack stack = new Stack();
        Node current = root;

        Node prev = null;

        while(!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                if (prev == null) {
                    prev = current;
                } else if (prev.value > current.value) {
                    System.out.println("Not BST");
                    break;
                }
                current = current.right;
            }
        }
    }
}
