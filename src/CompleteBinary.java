

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinary {

    public static void main(String args[]) {
        System.out.println(check(Tree.createCompleteBT()));
    }

    private static boolean check(Tree node) {
        if (node == null) {
            return false;
        }

        boolean ensureAllLeft = false;
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
                    return queue.isEmpty();
                }
                count = 0;
                ensureAllLeft = false;
            } else {
                ++count;
                if (t.left != null) {
                    if (ensureAllLeft) {
                        return false;
                    }
                    queue.add(t.left);
                }
                if (t.right != null) {
                    if (ensureAllLeft) {
                        return false;
                    }
                    queue.add(t.right);
                }
                else
                    ensureAllLeft = true;
            }
        }
        return true;
    }
}
