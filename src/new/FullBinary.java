package tree;

public class FullBinary {

    public static void main(String args[]) {
        System.out.println(check(Tree.createFullBT()));
    }

    private static boolean check(Tree node) {
        if (node != null) {
            if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
                return false;
            }
            return check(node.left) && check(node.right);
        } else {
            return true;
        }
    }

//    f (left, d)
//    f  (right, d)
}
