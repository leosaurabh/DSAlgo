import java.io.Serializable;

/**
 * Created by ss030277 on 4/30/15.
 */
public class Node implements Serializable{

    private static final long serialVersionUID = 2520925340917726122L;

    Node next;
    Node left;
    Node right;
    Integer value;
    char ch;
    boolean visited = false;
    int xVal;
    int yVal;
    Node children[];
    Node sibling;
    int currentIndex = -1;
    int index;

    public Node() {

    }

    public Node(int num, int index) {
        this.value = num;
        this.index = index;
    }

    public Node(Integer value) {
        this.value = value;
    }

    public Node(char value) {
        this.ch = value;
    }

    public Node(int value, int x, int y) {
        this.value = value;
        this.xVal = x;
        this.yVal = y;
    }

    public static Node getBTree() {
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

    public static Node oneMistakeBST() {
        //                    4
        //            6               2
        //        1       3       5       7
        Node root = new Node(4);
        root.left = new Node(6);
        root.right = new Node(2);

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
