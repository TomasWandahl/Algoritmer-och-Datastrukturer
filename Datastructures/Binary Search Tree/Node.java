/**
 * Node object
 * Created by Tomas on 2017-01-06.
 */
public class Node {
    int data;
    Node right;
    Node left;

    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    public void addRight(Node node) {
        this.right = node;
    }

    public void addLeft(Node node) {
        this.left = node;
    }

    public int getData() {
        return this.data;
    }

}
