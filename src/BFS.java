/**
 * Created by ss030277 on 5/4/15.
 */
public class BFS {

    public static void main(String args[]) {
        Queue queue = new Queue();
        Node root = TreeOld.getTree();
        int toFind = 4;

        if (root.value == toFind) {
            System.out.println("found->" + root);
        } else {
            queue.enQueue(root);
        }

        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.deQueue();
            if (node.value == toFind) {
                System.out.println("Found->" + node.value);
                break;
            } else {
                if (node.left != null) {
                    queue.enQueue(node.left);
                }
                if (node.right != null) {
                    queue.enQueue(node.right);
                }
            }
        }

    }
}