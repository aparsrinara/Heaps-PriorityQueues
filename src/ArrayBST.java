import java.util.ArrayList;

public class ArrayBST {
    private ArrayList<Node> contents = new ArrayList<Node>();

    public void insert(int value) {
        Node root = this.getNode(1);
        if (root != null) {
            root.insert(value);
        } else {
            Node newNode = new Node(value, this);
            this.setNode(1, newNode);
        }
    }

    public void printTree() {
        Node root = this.getNode(1);
        if (root != null) {
            root.print();
        }
    }

    private Node getNode(int index) {
        if (index >= contents.size()) {
            return null;
        } else {
            return contents.get(index);
        }
    }

    private void setNode(int index, Node n) {
        n.myIndex = index;
        // In the case that the ArrayList is not big enough
        // add null elements until it is the right size
        while (index + 1 >= contents.size()) {
            contents.add(null);
        }
        contents.set(index, n);
    }

    public boolean contains (int value) {
    	return this.containsHelper(contents.get(1), value);
    }
    
    public boolean containsHelper (Node n, int value) {
    	if (n == null) {
    		return false;
    	}
    	if (n.myValue == value) {
    		return true;
    	}
    	if (n.myValue < value) {
    		return containsHelper(n.getLeft(), value);
    	}
    	else {
    		return containsHelper(n.getRight(), value); 
    	}
    }
    
    
    private class Node {
        private int myValue;
        private int myIndex;
        private ArrayBST myTree;

        private Node(int value, ArrayBST tree) {
            this.myValue = value;
            this.myTree = tree;
        }

        // Get the left child of this node
        private Node getLeft() {
            return getNode(myIndex*2);
        }

        // Get the right child of this node
        private Node getRight() {
            return getNode(myIndex*2 + 1);
        }

        // Get the parent of this node
        private Node getParent() {
            return getNode(myIndex/2);
        }

        // Set the left child of this node
        private void setLeft(Node leftNode) {
            this.myTree.setNode(this.myIndex * 2, leftNode);
        }

        // Set the right child of this node
        private void setRight(Node rightNode) {
            this.myTree.setNode(this.myIndex * 2 + 1, rightNode);
        }

        // Print the tree in order
        private void print() {
            Node left = this.getLeft();
            if (left != null) {
                left.print();
            }
            System.out.println(this.myValue);
            Node right = this.getRight();
            if (right != null) {
                right.print();
            }
        }

        // Implement a BST insert method
        private void insert(int value) {
            // is it already in the tree?
            if (this.myValue == value) {
                return;
            }
            // should it go in the left subtree?
            else if (value < this.myValue) {
                Node left = this.getLeft();
                if (left != null) {
                    left.insert(value);
                } else {
                    this.setLeft(new Node(value, this.myTree));
                }
            }
            // should it go in the right subtree?
            else { // (value >= this.myValue)
                Node right = this.getRight();
                if (right != null) {
                    right.insert(value);
                } else {
                    this.setRight(new Node(value, this.myTree));
                }
            }
        }

    }

    public static void main(String[] args) {
        ArrayBST bst = new ArrayBST();
        bst.insert(9);
        bst.insert(8);
        bst.insert(7);
        bst.insert(6);
        bst.insert(11);
        bst.insert(10);
        bst.printTree();
    }

}