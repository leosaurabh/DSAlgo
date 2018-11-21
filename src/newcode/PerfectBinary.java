package newcode;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectBinary {

    public static void main(String args[]) {
        System.out.println(check(Tree.createPerfectBT()));
    }

    private static boolean check(Tree node) {
        if (node == null) {
            return false;
        }

        Queue<Tree> queue = new LinkedList<>();
        int depth = -1;
        int count = 0;
        Tree levelDelimiter = new Tree(null);
        queue.add(node);
        queue.add(levelDelimiter);

        while(!queue.isEmpty()) {
            Tree t = queue.poll();
            if (t.val == null){
                if (!queue.isEmpty())
                    queue.add(levelDelimiter);
                ++depth;
                if (count < Math.pow(2, depth)) {
                    return false;
                }
                count = 0;
            } else {
                ++count;
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
        }
        return true;
    }
}
