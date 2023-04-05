package main.java.mylib.datastructures.nodes;

public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;

    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    public TNode(int data, int balance, TNode parent, TNode left, TNode right) {
        this.data = data;
        this.balance = balance;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }



    // Getters and setters for member variables
    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TNode getLeft() {
        return this.left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return this.right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public TNode getParent() {
        return this.parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // Print method to display node information
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

    // toString method to return data member as string
    public String toString() {
        return String.valueOf(this.data);
    }
}
