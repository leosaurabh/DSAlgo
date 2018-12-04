import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ss030277 on 5/8/15.
 */
public class GraphDFSUsingAdjacencyList {

    private static Map<Node, List<Node>> adjacencyList =
            new HashMap<Node, List<Node>>();
    public static void main(String args[]) {


        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        adjacencyList.put(node1, Arrays.asList(node2, node3, node4));
        adjacencyList.put(node2, Arrays.asList(node1));
        adjacencyList.put(node3, Arrays.asList(node1, node4));
        adjacencyList.put(node4, Arrays.asList(node1, node3, node5));
        adjacencyList.put(node5, Arrays.asList(node4));

        Node node = getDFSNode(node2, 5);
        System.out.println(node.value);
    }

    private static Node getDFSNode(Node start, int num) {
        if (start == null) {
            return null;
        }

        if (start.value == num) {
            return start;
        }

        start.visited = true;
        List<Node> list = adjacencyList.get(start);

        if (list != null) {
            for (Node node : list) {
                if (node != null && !node.visited) {
                    return getDFSNode(node, num);
                }
            }
        }
        return null;
    }
}
