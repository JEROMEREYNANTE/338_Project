package main.java.mylib.datastructures.nodes;

/**
 * SNode class
 */
public class SNode {
    public int data;
    public SNode next;

    /**
     * Default constructor
     * 
     * @param data
     */
    public SNode(int data) {
        this.data = data;
        this.next = null;
    }

    /**
     * setter for next
     * 
     * @param head the next node
     */
    public void setNext(SNode head) {
        this.next = head;
    }

    /**
     * getter for next
     * 
     * @return the next node
     */
    public SNode getNext() {
        return this.next;
    }

    /**
     * getter for data
     * 
     * @return the data of the node
     */
    public int getData() {
        return this.data;
    }
}