import java.util.ArrayList;

public class ArrayHeap {
    private ArrayList<Node> contents = new ArrayList<Node>();

    public ArrayHeap() {
        // add a blank spot for the unused index
        contents.add(null);
    }

    public void insert(int value) {
    	// YOUR CODE HERE
    	
    }

    public Node removeMax() {
    	// YOUR CODE HERE
        return null;
    }

    private Node getNode(int index) {
        if (index >= contents.size()) {
            return null;
        } else {
            return contents.get(index);
        }
    }

    private void swap(Node node1, Node node2) {
        int index1 = node1.myIndex;
        int index2 = node2.myIndex;
        node1.myIndex = index2;
        node2.myIndex = index1;
        this.contents.set(index1, node2);
        this.contents.set(index2, node1);
    }

    private class Node {
        private int myValue;
        private int myIndex;
        private ArrayHeap myTree;

        private Node(int value, ArrayHeap tree) {
            this.myValue = value;
            this.myTree = tree;
        }

        // Get the left child of this node
        private Node getLeft() {
            return this.myTree.getNode(this.myIndex * 2);
        }

        // Get the right child of this node
        private Node getRight() {
            return this.myTree.getNode(this.myIndex * 2 + 1);
        }

        // Get the parent of this node
        private Node getParent() {
            return this.myTree.getNode(this.myIndex / 2);
        }

        // Bubble up a recently added node
        private void bubbleUp() {
        	//you fill this in
        }

        // Bubble down a swapped element after a call to removeMax
        private void bubbleDown() {
        	//you fill this in
        }

        // Determine the maximum of the two children
        // Invariant: Only one of node1 and node2 can be null.
        private Node max(Node node1, Node node2) {
            if (node1 == null) {
                return node2;
            } else if (node2 == null) {
                return node1;
            } else if (node1.myValue > node2.myValue) {
                return node1;
            } else {
                return node2;
            }
        }

    }

    public static void main(String[] args) {
        ArrayHeap heap = new ArrayHeap();
        heap.insert(3);
        heap.insert(9);
        heap.insert(7);
        heap.insert(4);
        heap.insert(1);
        heap.insert(8);
        heap.insert(5);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
    }

}