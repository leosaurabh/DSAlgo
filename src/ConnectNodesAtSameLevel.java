/**
 * Created by ss030277 on 6/1/15.
 */
public class ConnectNodesAtSameLevel {

    public static void main(String args[]) {
        Node root = Node.getTree();
        connectSiblings(root);
        System.out.println(root);
    }

    private static void connectSiblings(Node root) {

        //                    4
        //            2               6
        //        1       3       5       7

       if (root == null) {
           return;
       }

        Queue queue = new Queue();
        queue.enQueue(root);
        queue.enQueue(new Node(null));

        Node last = null;
        while(!queue.isEmpty()) {
            Node node = queue.deQueue();

            if (queue.isEmpty()) {
                break;
            }

            if (node.value == null) {
                last = null;
                queue.enQueue(new Node(null));
                continue;
            } else {
                if (last != null) {
                    last.sibling = node;
                }
                last = node;
            }
            if (node.left != null) {
                queue.enQueue(node.left);
            }

            if (node.right != null) {
                queue.enQueue(node.right);
            }
        }
    }
}
