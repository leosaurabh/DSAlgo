/**
 * Created by ss030277 on 5/31/15.
 */
public class NAryTree {

    public static Node getTree() {
//                            0
//
//                1           2           3
//
//        4   5   6       7   8   9     10  11  12

        int i = 0;
        Node root = new Node(i);
        root.children = new Node[3];
        root.children[0] = new Node(++i);
        root.children[1] = new Node(++i);
        root.children[2] = new Node(++i);

        root.children[0].children = new Node[3];
        root.children[0].children[0] = new Node(++i);
        root.children[0].children[1] = new Node(++i);
        root.children[0].children[2] = new Node(++i);

        root.children[1].children = new Node[3];
        root.children[1].children[0] = new Node(++i);
        root.children[1].children[1] = new Node(++i);
        root.children[1].children[2] = new Node(++i);

        root.children[2].children = new Node[3];
        root.children[2].children[0] = new Node(++i);
        root.children[2].children[1] = new Node(++i);
        root.children[2].children[2] = new Node(++i);

        return root;
    }
}
