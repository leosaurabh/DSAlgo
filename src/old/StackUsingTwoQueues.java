/**
 * Created by ss030277 on 6/3/15.
 */
public class StackUsingTwoQueues {

    private static Queue queueIn = new Queue();
    private static Queue queueOut = new Queue();

    public static void main(String args[]) {
        queueIn.enQueue(getNode(1));
        queueIn.enQueue(getNode(2));

        push(3);
        System.out.println(pop());
    }

    private static void push(int num) {
        queueIn.enQueue(getNode(num));
    }

    private static int pop() {
        Node popped = null;
        while(!queueIn.isEmpty()) {
            Node node = queueIn.deQueue();
            if (queueIn.isEmpty()) {
                popped = node;
                break;
            }
            queueOut.enQueue(node);
        }

        while(!queueOut.isEmpty()) {
            queueIn.enQueue(queueOut.deQueue());
        }

        return popped.value;
    }

    private static Node getNode(int num) {
        return new Node(num);
    }
}
