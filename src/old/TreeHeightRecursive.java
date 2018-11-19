/**
 * Created by ss030277 on 5/4/15.
 */
public class TreeHeightRecursive {

    public static void main(String args[]) {
        Node root = Tree.getTree();
        System.out.println(height(root));
    }

    private static int height(Node node) {
        if (node == null) {
            return 0;
        }
        int left_Height = height(node.left);
        int right_Height = height(node.right);
        return left_Height > right_Height ? left_Height + 1 : right_Height + 1;
    }
}
