/**
 * Created by ss030277 on 4/30/15.
 */
public class Queue {

    Node front = null;
    Node rear =  null;
    boolean isQueued = false;

    public void enQueue(Node node) {
        if (node == null) {
            return;
        }

        if (rear == null) {
            rear = node;
            front = node;
        } else {
            node.next = rear;
            rear = node;
        }
        isQueued = true;
    }

    public Node deQueue() {
        if (front != null) {
            Node trav = rear;

            if (front == rear) {
                front = null;
                rear = null;
                return trav;
            }

            while(front != trav.next) {
                trav = trav.next;
            }

            front = trav;
            trav = trav.next;
            front.next = null;
            return trav;
        }
        return null;
    }

    public Node getFront() {
        return front;
    }

    public boolean isEmpty() {
        return front == null && rear == null;
    }

    public void clear() {
        rear = null;
        front = null;
    }
}
