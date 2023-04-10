package main.java.mylib.datastructures.nodes;

/**
 * TNode class
 */
public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;

    /**
     * Default constructor
     */
    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    /**
     * Overload constructor
     * 
     * @param data    the data of the node
     * @param balance the balance of the node
     * @param parent  the parent of the node
     * @param left    the left child of the node
     * @param right   the right child of the node
     */
    public TNode(int data, int balance, TNode parent, TNode left, TNode right) {
        this.data = data;
        this.balance = balance;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    /**
     * getter for the node data
     * 
     * @return the data of the node
     */
    public int getData() {
        return this.data;
    }

    /**
     * setter for the node data
     * 
     * @param data the data of the node
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * getter for the left child
     * 
     * @return the left child of the node
     */
    public TNode getLeft() {
        return this.left;
    }

    /**
     * setter for the left child
     * 
     * @param left the left child of the node
     */
    public void setLeft(TNode left) {
        this.left = left;
    }

    /**
     * getter for the right child
     * 
     * @return the right child of the node
     */
    public TNode getRight() {
        return this.right;
    }

    /**
     * setter for the right child
     * 
     * @param right the right child of the node
     */
    public void setRight(TNode right) {
        this.right = right;
    }

    /**
     * getter for the parent
     * 
     * @return the parent of the node
     */
    public TNode getParent() {
        return this.parent;
    }

    /**
     * setter for the parent
     * 
     * @param parent the parent of the node
     */
    public void setParent(TNode parent) {
        this.parent = parent;
    }

    /**
     * getter for the balance
     * 
     * @return the balance of the node
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * setter for the balance
     * 
     * @param balance the balance of the node
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * print method to print the node data
     */
    public void print() {
        System.out.println("Node data: " + this.data);
        System.out.println("Node balance: " + this.balance);
        if (this.left != null) {
            System.out.println("Node left child: " + this.left.getData());
        } else {
            System.out.println("Node left child: null");
        }
        if (this.right != null) {
            System.out.println("Node right child: " + this.right.getData());
        } else {
            System.out.println("Node right child: null");
        }
        if (this.parent != null) {
            System.out.println("Node parent: " + this.parent.getData());
        } else {
            System.out.println("Node parent: null");
        }
    }

    /**
     * toString method to print the node data
     * 
     * @return the string representation of the node data
     */
    public String toString() {
        return String.valueOf(this.data);
    }
}
