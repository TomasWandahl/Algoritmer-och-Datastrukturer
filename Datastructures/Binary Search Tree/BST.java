/**
 * Binary Search Tree
 * Created by Tomas on 2017-01-06.
 */
public class BST {
    public static Node root;


    public BST() {
        this.root = null;
    }

    public boolean find(int data) {
        Node current = root;
        while (current != null) {
            if (data == current.getData()) {
                return true;
            } else if (data < current.getData()) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public boolean delete(int data) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        // Iterates until node to be deleted is found. In that case Current = Node to be deleted!
        while (current.getData() != data) {
            parent = current;

            if (current.getData() > data) {
                isLeftChild = true;
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        // When this section is reached, i have pinned downed the node to be deleted!

        //Case 1: Node has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        //Case 2: Node has only one child
        else if (current.right == null) { // Has left child
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) { // Has right child
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }

        // Node has two children
        else if (current.left != null && current.right != null) {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
        }
        return true;
    }

    public Node getSuccessor(Node deleleNode) {
        Node successsor = null;
        Node successsorParent = null;
        Node current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }


    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) { // empty tree
            System.out.println("Noden = null");
            this.root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;

        while (true) {
            parent = current;
            if (data < current.getData()) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }
}


