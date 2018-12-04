import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss030277 on 5/18/15.
 */
public class SerializeBTree {

    public static void main(String args[]) throws Exception{
        int i = 0;
        Node root = new Node(i);
        root.children = new Node[3];
        root.children[0] = new Node(++i);
        root.children[1] = new Node(++i);
        root.children[2] = new Node(++i);

        root.children[0].children = new Node[3];
        root.children[0].children[0] = new Node(++i);
        root.children[0].children[1] = new Node(++i);
        root.children[0].children[2] = new Node(++i);

        root.children[1].children = new Node[3];
        root.children[1].children[0] = new Node(++i);
        root.children[1].children[1] = new Node(++i);
        root.children[1].children[2] = new Node(++i);

        root.children[2].children = new Node[3];
        root.children[2].children[0] = new Node(++i);
        root.children[2].children[1] = new Node(++i);
        root.children[2].children[2] = new Node(++i);

        serializeBFT(root, new ObjectOutputStream(new FileOutputStream("/Users/ss030277/Desktop/a.txt")));
        Node node = deSerialize(new ObjectInputStream(new FileInputStream("/Users/ss030277/Desktop/a.txt")));
        System.out.println(node);
    }

    private static void serializeBFT (Node root, ObjectOutputStream outputStream) throws Exception {
        if (root == null) {
            outputStream.writeObject(null);
            return;
        }

        Queue queue = new Queue();
        queue.enQueue(root);

        while (!queue.isEmpty()) {
            Node temp = queue.deQueue();
            if (temp != null) {
                outputStream.writeObject(temp);
                if (temp.children != null) {
                    for (Node node : temp.children) {
                        queue.enQueue(node);
                    }
                }
            } else {
                outputStream.write(null);
            }
        }
    }

    private static Node deSerialize(ObjectInputStream inputStream) {
        if (inputStream == null) {
            return null;
        }

        List<Node> nodes = new ArrayList<Node>();
        Node root = null;
        try {
            while (true) {
                Object obj = inputStream.readObject();
                if (obj == null) {
                    nodes.add(null);
                } else {
                    nodes.add((Node) obj);
                }
            }
        } catch(Exception ex) {
            System.out.println("End of stream reached");
        }
        finally {
            Node currRoot = null;
            int length = 0;
            int count = 0;
            Node firstNotNul = null;
            for (Node temp : nodes) {
                if (currRoot == null) {
                    if (root == null && temp == null) {
                        throw new IllegalArgumentException("No tree exists");
                    }

                    if (root == null) {
                        root = temp;
                    }
                    currRoot = temp;
                    length = currRoot.children.length;
                    count = 0;
                } else {
                    if (count < length) {
                        currRoot.children[count] = temp;
                        if (temp != null) {
                            firstNotNul = temp;
                        }
                        ++count;
                    } else {
                        currRoot = firstNotNul;
                        if (currRoot != null) {
                            count = 0;
                            currRoot.children[count] = temp;
                            length = currRoot.children.length;
                            ++count;
                        }
                    }
                }
            }
        }

        return root;
    }
}
