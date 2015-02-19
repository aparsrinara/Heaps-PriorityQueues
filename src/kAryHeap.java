import java.util.ArrayList;

public class kAryHeap {

    private ArrayList<Node> contents = new ArrayList<Node>();
    private int branchingFactor;
    // more instance variables would go here

    public kAryHeap(int k) {
        // add a blank spot for the unused index
        contents.add(null);

        // TODO: Implement the rest of this method
        if (k < 0) {
        	 throw new IllegalArgumentException("Branching factor should not be negative!");
        }
        else {
        	branchingFactor = k;
        }
       
    }

    public void insert(int value) {
        Node newNode = new Node(value, this);
        newNode.myIndex = contents.size();
        contents.add(newNode);
        newNode.bubbleUp();
    }

    public Node removeMax() {
        if (this.contents.size() == 1) {
            return null;
        }

        Node max = this.contents.get(1);
        if (this.contents.size() == 2) {
            this.contents.remove(1);
            return max;
        }

        int lowestLocation = this.contents.size() - 1;
        Node lowest = this.contents.get(lowestLocation);
        this.contents.remove(lowestLocation);
        lowest.myIndex = 1;
        this.contents.set(1, lowest);
        lowest.bubbleDown();
        return max;
    }

    private Node getNode(int index) {
        if (index >= contents.size()) {
            return null;
        } else {
            return contents.get(index);
        }
    }
    
    public int removeMaxItem() {
        return removeMax().myValue;
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
        private kAryHeap myTree;

        private Node(int value, kAryHeap tree) {
            this.myValue = value;
            this.myTree = tree;
        }

        // Return the ith child of this node (i ranges from 1 to n)
        private Node getChild(int i) {
            // TODO: Implement this method
        	return this.myTree.getNode(branchingFactor*this.myIndex + (i-1));
        }

        // Get the parent of this node
        private Node getParent() {
            return this.myTree.getNode((int) (Math.ceil((double)this.myIndex/(double) branchingFactor)));
        }

        // Bubble up a recently added node.
        private void bubbleUp() {
        	System.out.println("PARENT of : " + this.myValue + "is" + this.getParent());
            while (this.getParent() != null
                    && this.myValue > this.getParent().myValue) {
            	System.out.println("HERE");
                swap(this, this.getParent());
            }
        }

        // Bubble down a swapped element after a call to removeMax
        private void bubbleDown() {
        	ArrayList<Node> children;
        	while (this.getChild(0) != null) {
        		children = new ArrayList<Node>();
	        	for (int i = 0; i < branchingFactor; i++) {
	        		children.add(this.getChild(i));
	        	}
	        	Node max = this.maxHelper(children);
	        	if (this.myValue > max.myValue) {
	        		break;
	        	}
	        	swap(this, max);
        	}
        }
        
        private Node maxHelper(ArrayList<Node> a) {
        	Node maximum = a .get(0);
        	int count = 1;
        	while (count < a.size())
        	{
        		maximum = this.max(maximum, a.get(count));
        		count++;
        	}
        	return maximum;
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

        public String toString() {
            return Integer.toString(myValue);
        }

    }

    private boolean isEmpty() {
        return contents.size() <= 1;
    }

    public String toString() {
        String toReturn = "";
        for (Node c : contents) {
            if (c != null) {
                toReturn += c.toString() + " ";
            }
        }
        return toReturn.trim();
    }

    public static void main(String[] args) {
        kAryHeap heap = new kAryHeap(3);
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
        // Should print in decreasing order
        while (!heap.isEmpty()) {
            System.out.println(heap.removeMax().myValue);
        }
    }

}