public class AllPathNumberSum {

//                     6
//                 /      \
//              3            5
//          /      \           \
//        2         5            4
//                /   \
//              7     4
//    There are 4 leaves, hence 4 root to leaf paths:
//    Path                    Number
//  6->3->2                   632
//          6->3->5->7               6357
//          6->3->5->4               6354
//          6->5>4                    654
//    Answer = 632 + 6357 + 6354 + 654 = 13997

    public int treePathsSum(Node node) {
        return sum(node, 0);
    }

    private int sum(Node node, int val) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 10*val + node.value;
        }

        return sum(node.left, val) + sum(node.right, val);
    }
}
