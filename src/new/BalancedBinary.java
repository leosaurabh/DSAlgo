package tree;


public class BalancedBinary {

    public static void main(String args[]) {
        //            1
        //        2      3
        //      4   5   6  7
        //    8  9
        Tree root = Tree.createCompleteBT();
        System.out.println(check(root, 0));
    }

    private static int check(Tree node, int depth) {
        if (node != null) {
            int left = check(node.left, depth + 1);
            int right = check(node.right, depth + 1);
            if (Math.abs(left - right) > 1) {
                return -1;
            } else {
                return Math.max(left, right);
            }
        } else {
            return depth - 1;
        }
    }
}
