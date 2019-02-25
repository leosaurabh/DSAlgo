import java.util.LinkedList;
import java.util.Queue;

class Graph {

    class GraphNode {
        int val;
        GraphNode[] neighbors;
        boolean visited;

        GraphNode(int val, int size) {
            this.val = val;
            this.neighbors = new GraphNode[size];
        }
    }

    GraphNode dfs(GraphNode node, int val) {
        if (node == null) {
            return null;
        }

        node.visited = true;
        if (node.val == val) {
            return node;
        }

        if (node.neighbors != null) {
            for (GraphNode neighbor : node.neighbors) {
                if (neighbor != null && !neighbor.visited) {
                    GraphNode result = dfs(neighbor, val);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }

        return null;
    }

    GraphNode bfs(GraphNode node, int val) {
        if (node == null) {
            return null;
        }

        node.visited = true;
        if (node.val == val) {
            return node;
        }

        Queue<GraphNode> q = new LinkedList<GraphNode>();
        q.add(node);

        while (!q.isEmpty()) {
            GraphNode temp = q.remove();
            if (temp != null && temp.neighbors != null && temp.neighbors.length != 0) {

                for (GraphNode neighbor : node.neighbors) {
                    if (neighbor != null && !neighbor.visited) {
                        neighbor.visited = true;
                        if (neighbor.val == val) {
                            return neighbor;
                        } else {
                            q.add(neighbor);
                        }
                    }
                }
            }
        }
        return null;
    }

    GraphNode clone(GraphNode node) {
        if (node == null) {
            return null;
        }

        node.visited = true;
        GraphNode newGraph = new GraphNode(node.val, getSize(node));
        GraphNode node1 = newGraph;

        Queue<GraphNode> q = new LinkedList<GraphNode>();
        q.add(node);
        q.add(node1);

        while(!q.isEmpty()) {
            node = q.remove();
            node1 = q.remove();

            if (node != null && node1 != null && node.neighbors != null) {
                int i = -1;
                for (GraphNode neighbor : node.neighbors) {
                    if (!neighbor.visited) {
                        node1.neighbors[++i] = new GraphNode(neighbor.val, getSize(neighbor));
                        neighbor.visited = true;
                        node1.neighbors[i].visited = true;

                        q.add(neighbor);
                        q.add(node1.neighbors[i]);
                    }
                }
            }
        }

        return newGraph;
    }

    private int getSize(GraphNode node) {
        return node.neighbors != null ? node.neighbors.length : 0;
    }
}

