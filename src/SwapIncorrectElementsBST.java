public class SwapIncorrectElementsBST {

    static Node n1 = null;
    static Node n2 = null;
    static Node n3 = null;

    //                    4
    //            6               2
    //        1       3       5       7
    public static void main(String[] args) {
        Node root = Node.oneMistakeBST();
        swap(root);
        System.out.println();
    }

    public static void swap(Node root) {
        swap(root,null);

        if (n3 == null) {
            int temp = n2.value;
            n2.value = n1.value;
            n1.value = temp;
        } else {
            int temp = n3.value;
            n3.value = n1.value;
            n1.value = temp;
        }
    }

    private static void swap(Node node, Node prev) {
        if (node == null) {
            return;
        }

        swap(node.left, prev);

        if (prev != null && node.value < prev.value) {
            if (n1 == null) {
                n1 = prev;
                n2 = node;
            } else {
                n3 = node;
            }
        }
        prev = node;

        swap(node.right, prev);
    }
}
