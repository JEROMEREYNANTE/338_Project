package main.java.mylib.datastructures.nodes;

/**
 * DNode class
 */
public class DNode {
    public int data;
    public DNode next;
    public DNode prev;

    /**
     * Default constructor
     * 
     * @param data
     */
    public DNode(int data) {
        this.data = data;
    }

    /**
     * setter for next
     * 
     * @param head the next node
     */
    public void setNext(DNode head) {
        this.next = head;
    }

    /**
     * getter for next
     * 
     * @return the next node
     */
    public DNode getNext() {
        return this.next;
    }

    /**
     * setter for prev
     * 
     * @param tail the previous node
     */
    public void setPrev(DNode tail) {
        this.prev = tail;
    }

    /**
     * getter for prev
     * 
     * @return the previous node
     */
    public DNode getPrev() {
        return this.prev;
    }

    /**
     * getter for data
     * 
     * @return the data of the node
     */
    public int getData() {
        return this.data;
    }

    /**
     * setter for data
     * 
     * @param data the data of the node
     */
    public void setData(int data) {
        this.data = data;
    }

}
