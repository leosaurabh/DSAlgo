import java.util.HashMap;
import java.util.Map;

/**
 * Created by ss030277 on 5/31/15.
 */
public class NAryCommonAncestor {

    public static void main(String args[]) {
        Node root = NAryTree.getTree();
        root.visited = true;
        markPath(root, 1);
        markPath(root, 11);
        Node commonAncestor = getCommonAncestor(root);
        System.out.println(commonAncestor.value);
    }

    private static Node getCommonAncestor(Node root) {
        Queue queue = new Queue();
        queue.enQueue(root);

        while (!queue.isEmpty()) {
            Node node = queue.deQueue();
            if (node.children != null) {
                int count = 0;
                for (Node child : node.children) {

                    if (child.visited) {
                        ++count;
                    }

                    if (count > 1) {
                        return node;
                    }
                    queue.enQueue(child);
                }
            }
        }
        return null;
    }

    private static Node markPath(Node root, int num) {
        if (root != null && root.children != null) {

            for (Node child : root.children) {

                if (child != null && child.value == num) {
                    child.visited = true;
                    return child;
                }

                Node node = markPath(child, num);


                if (child != null && node != null && node.visited) {
                    child.visited = true;
                    return child;
                }
            }
        }
        return null;
    }
}
