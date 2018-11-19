import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss030277 on 4/30/15.
 */
public class PerfectBinaryTest {

    public static void main(String args[]) {
        Node root = Tree.getTree();

        Queue queue = new Queue();
        queue.enQueue(root);

        int count = 1;
        int currCount = 0;
            Node node;
            while ((node = queue.deQueue()) != null) {
                ++currCount;
                if (currCount == count) {
                    count *= 2;
                    currCount = 0;
                } else if (queue.isEmpty() && currCount < count) {
                    System.out.println("Not perfect");
                    break;
                }

                queue.enQueue(node.left);
                queue.enQueue(node.right);
            }
    }
}
