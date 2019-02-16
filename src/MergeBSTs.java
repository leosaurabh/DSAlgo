public class MergeBSTs {

    public static void main(String[] args) {
        Node n1 = new Node(3);
        n1.left = new Node(1);
        n1.right = new Node(5);

        Node n2 = new Node(4);
        n2.left = new Node(2);
        n2.right = new Node(6);
        merge(n1, n2);
    }

    public static void merge(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        Stack s1 = new Stack();
        Stack s2 = new Stack();

        Node cur1 = node1;
        Node cur2 = node2;

        while (!s1.isEmpty() || cur1 != null || !s2.isEmpty() || cur2 != null) {
            if (cur1 != null || cur2 != null) {
                if (cur1 != null) {
                    s1.push(cur1);
                    cur1 = cur1.left;
                }

                if (cur2 != null) {
                    s2.push(cur2);
                    cur2 = cur2.left;
                }
            } else {
                Node t1 = s1.peek();
                Node t2 = s2.peek();

                if (t1 != null && t2 != null) {
                    if (t1.value < t2.value) {
                        cur1 = s1.pop();
                        System.out.print(cur1.value + " ");
                        cur1 = cur1.right;
                    } else if (t1.value > t2.value) {
                        cur2 = s2.pop();
                        System.out.print(cur2.value + " ");
                        cur2 = cur2.right;
                    } else {
                        cur1 = s1.pop();
                        System.out.print(cur1.value + " ");
                        cur1 = cur1.right;

                        cur2 = s2.pop();
                        System.out.print(cur2.value + " ");
                        cur2 = cur2.right;
                    }
                } else {
                    if (s1.isEmpty()) {
                        System.out.println(s2.pop().value);
                    } else if (s2.isEmpty()) {
                        System.out.println(s1.pop().value);
                    }
                }
            }
        }
    }
}
