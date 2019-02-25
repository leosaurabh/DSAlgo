public class AlternateRevBFS {

    public void printAlternateBFS(Node root) {
        if (root == null) {
            return;
        }

        Stack st = new Stack();
        st.push(root);

        Queue q = new Queue();

        while(!st.isEmpty() || !q.isEmpty()) {
            if (!st.isEmpty()) {
                Node temp = st.pop();
                if (temp != null) {
                    System.out.println(temp.value);

                    if (temp.left != null)
                        q.enQueue(temp.left);
                    if (temp.right != null)
                        q.enQueue(temp.right);
                }
            } else if(!q.isEmpty()) {
                Node temp = q.deQueue();
                if (temp != null) {
                    System.out.println(temp.value);

                    if (temp.left != null)
                        st.push(temp.left);
                    if (temp.right != null)
                        st.push(temp.right);
                }
            }
        }
    }
}
