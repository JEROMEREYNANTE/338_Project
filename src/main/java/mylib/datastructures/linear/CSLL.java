package main.java.mylib.datastructures.linear;
import main.java.mylib.datastructures.nodes.SNode;

public class CSLL extends SLL{
    private SNode head;
    private SNode tail;
    private int size;

    public CSLL() {
        super();
    }

    public CSLL(SNode head) {
        super(head);
        head.setNext(head); // set the tail to be the head to create a circular loop
    }

    @Override
    public void insertHead(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
            node.next = head;
        } else {
            node.next = head;
            head = node;
            tail.next = head;
        }
        size++;
    }

    @Override
    public void insertTail(SNode node) {
        if (head == null) {
            insertHead(node);
        } else {
            tail.next = node;
            tail = node;
            tail.next = head;
            size++;
        }
    }

    @Override
    public void deleteHead() {
        if (head == null) {
            return;
        }
        if (head.getNext() == head) { // if there's only one node in the list
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            tail.setNext(head); // update the tail to reference the new head
        }
        size--;
    }

    @Override
    public void deleteTail() {
        if (tail == null) {
            return;
        }
        if (tail == head) { // if there's only one node in the list
            head = null;
            tail = null;
        } else {
            SNode current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            current.setNext(head); // update the node before the tail to reference the head
            tail = current;
        }
        size--;
    }

    @Override
    public void delete(SNode node) {
        if (head == null) {
            return;
        }
        if (head == node) {
            deleteHead();
            return;
        }
        if (tail == node) {
            deleteTail();
            return;
        }
        SNode current = head;
        while (current.getNext() != head && current.getNext() != node) {
            current = current.getNext();
        }
        if (current.getNext() == node) {
            current.setNext(node.getNext());
            size--;
        }
    }

    @Override
    public void clear(SNode node) {
        head = null;
        tail = null;
        size = 0;

    }

}
