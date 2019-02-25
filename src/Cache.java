import java.util.HashMap;

// LRU
public class Cache {

    class Node {
        String key;
        int val;
        Node left;
        Node right;

        Node(String key, int val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    int size;
    int count;
    Node start;
    Node end;
    HashMap<String, Node> cache = new HashMap<>();

    int get(String key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            if (node != null){
                remove(node);
                add(node);
                return node.val;
            }
        }
        return -1;
    }

    void write(String key, int val) {
        if (key != null) {
            if (!this.cache.containsKey(key)) {
                Node node = new Node(key, val);
                this.cache.put(key, node);
                add(node);
            }
        }
    }

    void remove(Node node) {
        if (node.left != null) {
            node.left.right = node.right;
            if (node.right != null) {
                node.right.left = node.left;
            }
            node.left = null;
            node.right = null;
        } else {
            if (node.right != null) {
                node.right.left = null;
            }
            node.right = null;
        }
    }

    void add(Node node) {
        this.count++;
        if (this.count > this.size) {
            evict();
        }
        this.start.right = node;
        node.left = this.start;
        this.start = node;
    }

    void evict() {
        if (this.end != null) {
            Node temp = this.end;
            this.end = this.end.right;
            if (this.end != null) {
                this.end.left = null;
                temp.right = null;
            }
        }
    }
}
