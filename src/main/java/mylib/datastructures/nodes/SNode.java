package main.java.mylib.datastructures.nodes;

public class SNode {
    public int data;
    public SNode next;

    // Constructor
    public SNode(int data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(SNode head) {
        this.next = head;
    }

    public SNode getNext() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }
}