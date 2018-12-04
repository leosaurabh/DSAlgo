/**
 * Created by ss030277 on 4/30/15.
 */
public class Stack {

    Node top = null;
    int size = 0;

    public void push(Node node) {
        if (top == null) {
            top = node;
            node.next = null;
        } else {
            node.next = top;
            top = node;
        }
        ++size;
    }

    public Node pop() {
        if (top != null) {
            Node returnVal = top;
            top = top.next;
            returnVal.next = null;
            return returnVal;
        }
        --size;
        return null;
    }

    public Node peek() {
        if (top != null) {
            return top;
        }
        return null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }
}
