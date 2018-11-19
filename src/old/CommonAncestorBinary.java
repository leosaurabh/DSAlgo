/**
 * Created by ss030277 on 6/1/15.
 */
public class CommonAncestorBinary {

    public static void main(String args[]) {
        System.out.println(findAncestor(Tree.getTree(), 1, 7).value);
    }

    private static Node findAncestor(Node node, int start, int end) {
        if (node == null) {
            return null;
        }

        if (node.value == start || node.value == end) {
            return node;
        }

        Node left = findAncestor(node.left, start, end);
        Node right = findAncestor(node.right, start, end);

        if (left != null && right != null) {
            return node;
        }

        return left != null ? left : right;
    }
}
