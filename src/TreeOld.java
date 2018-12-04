/**
 * Created by ss030277 on 4/30/15.
 */
public class TreeOld {

    public static Node getTree() {
//                    4
//            2               6
//        1       3       5       7
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);

        Node left = root.left;
        left.left = new Node(1);
        left.right = new Node(3);
//
        Node right = root.right;
        right.left = new Node(5);
        right.right = new Node(7);

        return root;
    }
}
