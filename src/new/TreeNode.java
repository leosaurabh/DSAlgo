package tree;

public class Tree {

    Integer val;
    Tree left;
    Tree right;

    public Tree(Integer value) {
        this.val = value;
    }

    public static Tree createCompleteBT() {
        Tree root = new Tree(1);
        Tree left = new Tree(2);
        Tree right = new Tree(3);
        root.left = left;
        root.right = right;

        left.left = new Tree(4);
        left.right = new Tree(5);

        right.left = new Tree(6);
        right.right = new Tree(7);

        left.left.left = new Tree(8);
        left.left.right = new Tree(9);
        //            1
        //        2      3
        //      4   5   6  7
        //    8  9

//        left.right.right = new Tree(9);
//        //            1
//        //        2      3
//        //      4   5   6  7
//        //    8       9
        return root;
    }

    public static Tree createFullBT() {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);

        root.left.left = new Tree(4);
        root.left.right = new Tree(5);

//          1
//        2    3
//      4   5
        return root;
    }

    public static Tree createPerfectBT() {
        Tree root = new Tree(1);
        Tree left = new Tree(2);
        Tree right = new Tree(3);
        root.left = left;
        root.right = right;

        left.left = new Tree(4);
        left.right = new Tree(5);

        right.left = new Tree(6);
        right.right = new Tree(7);
        //            1
        //        2      3
        //      4   5   6  7
        return root;
    }

    public static Tree createDegenerateBT() {
        Tree root = new Tree(1);
        Tree left = new Tree(2);
        root.left = left;

        left.right = new Tree(3);

        left.right.left = new Tree(4);
        //           1
        //        2
        //          3
        //        4
        return root;
    }
}
