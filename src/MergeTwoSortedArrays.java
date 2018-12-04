import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ss030277 on 4/7/15.
 */
public class MergeTwoSortedArrays {

    static class Tree {
        Tree left;
        Tree right;
        int value;
    }

    public static void main(String args[]) {
        List<Integer> list1 = Arrays.asList(11,4,68,5);
        List<Integer> list2 = Arrays.asList(5,4,3,2);
        List<Integer> finalList = new ArrayList<Integer>();

        Tree root = null;
        root = sortList(list1, root);
        sortList(list2, root);
        populateFinalList(finalList, root);
        System.out.println(finalList);
    }

    private static Tree sortList(List<Integer> list, Tree node) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        for (int value: list) {
            node = placeInTree(value, node);
        }

        return node;
    }

    private static Tree placeInTree(int value, Tree root) {
        if (root == null) {
            root = new Tree();
            root.value = value;
        } else {
            Tree node = root;
            while (true) {
                if (value <= node.value) {
                    if (node.left == null) {
                        node.left = new Tree();
                        node.left.value = value;
                        break;
                    } else {
                        node = node.left;
                    }
                } else {
                    if (node.right == null) {
                        node.right = new Tree();
                        node.right.value = value;
                        break;
                    } else {
                        node = node.right;
                    }
                }
            }
        }
        return root;
    }

    private static void populateFinalList(List<Integer> finalList, Tree node) {
        if (node != null) {
            populateFinalList(finalList, node.left);
            finalList.add(node.value);
            populateFinalList(finalList, node.right);
        }
    }
}
