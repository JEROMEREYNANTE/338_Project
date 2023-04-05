package main.java.mylib.datastructures.nodes;

public class DNode {
    public int data;
    public DNode next;
    public DNode prev;

    // Constructor
    public DNode(int data) {
        this.data = data;
    }

    public void setNext(DNode head) {
        this.next = head;
    }

    public DNode getNext() {
        return this.next;
    }

    public void setPrev(DNode tail) {
        this.prev = tail;
    }

    public DNode getPrev() {
        return this.prev;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

}
