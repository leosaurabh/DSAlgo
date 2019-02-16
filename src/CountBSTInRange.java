public class CountBSTInRange {

    public static void main(String[] args) {
        Node root = Node.getTree();
        System.out.println(getCount(root, 1, 3));
    }

    //                    4
    //            2               6
    //        1       3       5       7
    public static int getCount(Node node, int low, int high) { //3,5
//        if (node == null)
//            return count;
//
//        if (node.left != null) {
//            getCount(node.left, low, high, count);
//        }
//
//        if (node.value >= low && node.value <= high) {
//            ++count;
//        }
//
//        if (node.right != null) {
//            getCount(node.right, low, high, count);
//        }
        if (node == null) {
            return 0;
        }

        if (node.value >= low && node.value <= high) {
            return 1 + getCount(node.left, low, high) + getCount(node.right, low, high);
        } else {
            return getCount(node.left, low, high) + getCount(node.right, low, high);
        }


    }
}
