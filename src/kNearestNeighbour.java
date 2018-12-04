import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss030277 on 5/7/15.
 */
public class kNearestNeighbour {

    private static int count = 0;

    public static void main(String args[]) {
        List<Integer[]> points = new ArrayList<Integer[]>();
        points.add(new Integer[]{1,1});
        points.add(new Integer[]{-1,1});
        points.add(new Integer[]{2,3});
        points.add(new Integer[]{10,3});
        points.add(new Integer[]{4,5});
        points.add(new Integer[]{3,3});

        count = 3;
        Node root = null;

        for (Integer[] arr : points) {
            int distance = (int) Math.sqrt(arr[0]*arr[0] + arr[1]*arr[1]);
            if (root == null) {
                root = new Node(distance, arr[0], arr[1]);
            } else {
                Node temp = root;
                pushNode(temp, distance, arr[0], arr[1]);
            }
        }
        traverseAndPrint(root);
    }

    private static void pushNode(Node node, int distance, int x, int y) {
        Node insert = new Node(distance, x, y);

        while(true) {
            if (node.value < insert.value) {
                if (node.right == null) {
                    node.right = insert;
                    break;
                } else {
                    node = node.right;
                }
            } else {
                if (node.value >= insert.value) {
                    if (node.left == null) {
                        node.left = insert;
                        break;
                    } else {
                        node = node.left;
                    }
                }
            }
        }
    }

    private static void traverseAndPrint(Node node) {
        if (node != null) {
            traverseAndPrint(node.left);
            if (count > 0) {
                System.out.println(node.xVal + "," + node.yVal + " > " + node.value);
                --count;
            }
            traverseAndPrint(node.right);
        }
    }
}
