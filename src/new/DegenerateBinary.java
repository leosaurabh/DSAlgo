package tree;

import java.util.LinkedList;
import java.util.Queue;

public class DegenerateBinary {

    public static void main(String args[]) {
        System.out.println(check(Tree.createDegenerateBT()));
    }

    private static boolean check(Tree node) {
        if (node != null) {
            if (node.left != null && node.right != null) {
                return false;
            }
            return check(node.left) && check(node.right);
        } else {
            return true;
        }
    }
}
