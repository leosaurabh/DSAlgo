import com.sun.corba.se.pept.encoding.InputObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss030277 on 6/1/15.
 */
public class NAryTreeSendOverWire {

    public static void main(String args[]) throws Exception{
        Node root = Node.getBTree();
//        Socket socket = new Socket("localhost", 3000);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/ss030277/Desktop/a.txt"));
        serialize(root, out);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/ss030277/Desktop/a.txt"));
        root = deSerialize(objectInputStream, root.children.length);
        System.out.println(root.value);
    }

    private static void serialize(Node root, ObjectOutputStream out) throws  Exception{
        Queue queue = new Queue();
        queue.enQueue(root);

        while(!queue.isEmpty()) {
            Node node = queue.deQueue();

            if (node == null) {
                node = new Node(null);
            }

            out.writeObject(node);

            if (node.children != null) {
                for (Node child : node.children) {
                    queue.enQueue(child);
                }
            }
        }
    }

    private static Node deSerialize(ObjectInputStream inputStream, int numberOfChildren) {
        if (inputStream == null) {
            return null;
        }

        List<Node> nodes = new ArrayList<Node>();

        Object obj = null;
        try {
            while ((obj = inputStream.readObject()) != null) {
                nodes.add((Node) obj);
            }
        } catch(Exception ex) {
            System.out.println(nodes.size());
        }

        int length = nodes.size();
        int i = 0;
        while(numberOfChildren*(i+1) < length) {
            int j = 0;
            Node node = nodes.get(i);
            node.children = new Node[numberOfChildren];
            while (j < numberOfChildren) {
                Node temp = nodes.get(numberOfChildren*(i)+j+1);
                node.children[j] = temp.value == null ? null : temp;
                ++j;
            }
            ++i;
        }
        return nodes.isEmpty() ? null : nodes.get(0);
    }
}
