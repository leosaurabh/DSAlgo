/**
 * Created by ss030277 on 4/30/15.
 */
public class LevelTraversal {

    public static void main(String args[]) {
        Node root = TreeOld.getTree();
        Queue queue = new Queue();
        queue.enQueue(root);

        while(!queue.isEmpty()) {
            Node node = queue.deQueue();

            if (node != null) {
                System.out.println(node.value);

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
