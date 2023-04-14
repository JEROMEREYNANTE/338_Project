package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

/**
 * Circular Doubly Linked List that extends the DLL class
 */
public class CDLL extends DLL {
    private DNode head;
    private DNode tail;
    private int size;

    /**
     * Default constructor
     */
    public CDLL() {
        super();
    }

    /**
     * Overload constructor
     * 
     * @param node
     */
    public CDLL(DNode node) {
        super(node);
    }

    /**
     * Insert a node at the tail of the list
     * 
     * @param node
     */
    @Override
    public void InsertTail(DNode node) {
        if (tail == null) {
            head = node;
            tail = node;
            head.setPrev(tail);
            tail.setNext(head);
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            node.setNext(head);
            head.setPrev(node);
            tail = node;
        }
        size++;
    }

    /**
     * Insert a node at the head of the list
     * 
     * @param node
     */
    @Override
    public void InsertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            head.setPrev(tail);
            tail.setNext(head);
        } else {
            head.setPrev(node);
            node.setNext(head);
            node.setPrev(tail);
            tail.setNext(node);
            head = node;
        }
        size++;
    }

    /**
     * Deletes the tail of the list
     */
    @Override
    public void DeleteTail() {
        if (tail == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        tail = tail.getPrev();
        tail.setNext(head);
        head.setPrev(tail);
        size--;
    }

    /**
     * Deletes the head of the list
     */
    @Override
    public void DeleteHead() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        head = head.getNext();
        head.setPrev(tail);
        tail.setNext(head);
        size--;
    }

    /**
     * Insert a node at a specific position in the list
     * 
     * @param node
     * @param position
     */
    @Override
    public void Insert(DNode node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            InsertHead(node);
        } else if (position == size) {
            InsertTail(node);
        } else {
            DNode current = head;
            for (int i = 0; i < position; i++) {
                current = current.getNext();
            }
            node.setNext(current);
            node.setPrev(current.getPrev());
            current.getPrev().setNext(node);
            current.setPrev(node);
            size++;
        }
    }

    /**
     * Deletes a node from the list
     * 
     * @param node
     */
    @Override
    public void Delete(DNode node) {
        if (head == null) {
            return;
        }
        if (head == node) {
            DeleteHead();
            return;
        }
        if (tail == node) {
            DeleteTail();
            return;
        }
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
    }

    /**
     * Sorts the list
     */
    @Override
    public void Sort() {
        if (head == null) {
            return;
        }
        DNode current = head.getNext();
        while (current != head) {
            DNode node = current;
            while (node.getPrev() != head.getPrev() && node.getData() < node.getPrev().getData()) {
                DNode temp = node.getPrev();
                node.setPrev(temp.getPrev());
                temp.getPrev().setNext(node);
                temp.setNext(node.getNext());
                node.getNext().setPrev(temp);
                node.setNext(temp);
                temp.setPrev(node);
            }
            current = current.getNext();
        }
    }

    /**
     * Search for a node in the list
     * 
     * @param node
     * @return the node if found, null otherwise
     */
    @Override
    public DNode search(DNode node) {
        if (head == null) {
            return null;
        }
        DNode current = head;
        do {
            if (current == node) {
                return current;
            }
            current = current.getNext();
        } while (current != head);
        return null;
    }

    /**
     * Sort the list
     * 
     * @param node
     */
    @Override
    public void sortedInsert(DNode node) {
        if (head == null) {
            InsertHead(node);
        } else if (node.getData() <= head.getData()) {
            InsertHead(node);
        } else if (node.getData() >= tail.getData()) {
            InsertTail(node);
        } else {
            DNode current = head.getNext();
            while (current != head && current.getData() < node.getData()) {
                current = current.getNext();
            }
            node.setNext(current);
            node.setPrev(current.getPrev());
            current.getPrev().setNext(node);
            current.setPrev(node);
            size++;
        }
    }
}
