package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

/**
 * Circular Singly Linked List class that extends the SLL class
 */
public class CSLL extends SLL {
    private SNode head;
    private SNode tail;
    private int size;

    /**
     * Default constructor
     */
    public CSLL() {
        super();
    }

    /**
     * Overload constructor
     * 
     * @param head
     */
    public CSLL(SNode head) {
        super(head);
        head.setNext(head);
    }

    /**
     * Insert a node at the head of the list
     * 
     * @param node
     */
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

    /**
     * Insert a node at the tail of the list
     * 
     * @param node
     */
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

    /**
     * Deletes the head of the list
     */
    @Override
    public void deleteHead() {
        if (head == null) {
            return;
        }
        if (head.getNext() == head) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            tail.setNext(head);
        }
        size--;
    }

    /**
     * Deletes the tail of the list
     */
    @Override
    public void deleteTail() {
        if (tail == null) {
            return;
        }
        if (tail == head) {
            head = null;
            tail = null;
        } else {
            SNode current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            current.setNext(head);
            tail = current;
        }
        size--;
    }

    /**
     * Deletes a node from the list
     * 
     * @param node
     */
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

    /**
     * Clears the list
     * 
     * @param node
     */
    @Override
    public void clear(SNode node) {
        head = null;
        tail = null;
        size = 0;

    }

}
