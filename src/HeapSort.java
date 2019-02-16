import java.util.ArrayList;
import java.util.List;

public class HeapSort {

    public static List<Integer> sortData(int[] nums) {
        Tree root = sort(nums);
        List<Integer> sorted = new ArrayList<>();
        populate(sorted, root);
        return sorted;
    }

    private static void populate(List<Integer> sorted, Tree node) {
        if (node != null) {
            populate(sorted, node.left);
            sorted.add(node.val);
            populate(sorted, node.right);
        }
    }

    private static Tree sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Tree root =  null;
        for (int n : nums) {
            if (root == null) {
                root = new Tree(n);
            } else {
                place(new Tree(n), root);
            }
        }
        return root;
    }

    private static void place(Tree node, Tree root) {
        Tree temp = root;

        while(true) {
            if (temp.val >= node.val) {
                if (temp.left == null) {
                    temp.left = node;
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
    }
}
