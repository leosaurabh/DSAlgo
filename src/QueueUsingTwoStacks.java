/**
 * Created by ss030277 on 6/3/15.
 */
public class QueueUsingTwoStacks {

    private static Stack stackIn = new Stack();
    private static Stack stackOut = new Stack();

    public static void main(String args[]) {
       stackIn.push(getNode(1));
       stackIn.push(getNode(2));
       stackIn.push(getNode(3));
        enqueue(4);
        System.out.println(dequeue());
    }

    private static void enqueue(int num) {
        stackIn.push(getNode(num));
    }

    private static int dequeue() {
        Node dequeued = null;

        while(!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }

        dequeued = stackOut.pop();

        while(!stackOut.isEmpty()) {
            stackIn.push(stackOut.pop());
        }

        return dequeued.value;
    }

    private static Node getNode(int num) {
        return new Node(num);
    }
}
