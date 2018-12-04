/**
 * Created by ss030277 on 5/21/15.
 */
public class IterativeDeepening {

    private static Node found = null;

    public static void main(String args[]) {
        Node root = Node.getBTree();
        int depth = 2;
        Node result = searchVal(root, depth, 2);
        System.out.println(result.value);
    }

    //                            0
    //
    //                1           2           3
    //
    //        4   5   6       7   8   9     10  11  12

    private static Node searchVal(Node node, int depth, final int num) {
        if (node == null) {
            return null;
        }

        if (node.value == num) {
            return node;
        }

        if (node.children != null && depth > 0) {
            for (Node child : node.children) {
                if (child != null) {
                    Node temp = searchVal(child, depth - 1, num);
                    if (temp != null) {
                        return temp;
                    }
                }
            }
        }
        return null;
    }
}