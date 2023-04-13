package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

/**
 * Singly Linked List class
 */
public class SLL {

    protected SNode head;
    private SNode tail;
    private int size;

    /**
     * Default constructor
     */
    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Overload constructor
     * 
     * @param head
     */
    public SLL(SNode head) {
        this.head = head;
        this.tail = head;
        // this.size = 1;

    }

    /**
     * Insert a node at the head of the list
     * 
     * @param node
     */
    public void insertHead(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
            size++;
        } else {
            node.setNext(head);
            head = node;
        }
        node.setNext(null);

    }

    /**
     * Insert a node at the tail of the list
     * 
     * @param node
     */
    public void insertTail(SNode node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    /**
     * Insert a node at a specific position in the list
     * 
     * @param node
     * @param position
     */
    public void insert(SNode node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            SNode current = head;
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
        head.setNext(null);
    }

    /**
     * Sort the list
     * 
     * @param node
     */
    public void sortedInsert(SNode node) {
        if (!isSorted()) {
            sort();
        }
        SNode current = head;
        SNode prev = null;
        while (current != null && current.getData() < node.getData()) {
            prev = current;
            current = current.getNext();
        }
        if (prev == null) {
            insertHead(node);
        } else {
            node.setNext(current);
            prev.setNext(node);
            size++;
            if (current == null) {
                tail = node;
            }
        }
        head.setNext(null);
    }

    /**
     * checks if the list is sorted
     * 
     * @return true if sorted, false otherwise
     */
    private boolean isSorted() {
        if (head == null || head.getNext() == null) {
            return true;
        }
        SNode current = head;
        while (current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    /**
     * Search for a node in the list
     * 
     * @param node
     * @return the node if found, null otherwise
     */
    public SNode search(SNode node) {
        SNode current = head;
        while (current != null) {
            if (current.getData() == node.getData()) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Deletes the head of the list
     */
    public void deleteHead() {
        if (head == null) {
            return;
        }
        head = head.getNext();
        size--;
        if (head == null) {
            tail = null;
        }
    }

    /**
     * Deletes the tail of the list
     */
    public void deleteTail() {
        if (tail == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        SNode current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }
        current.setNext(null);
        tail = current;
        size--;
    }

    /**
     * Deletes a node from the list
     * 
     * @param node
     */
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
        while (current.getNext() != null && current.getNext() != node) {
            current = current.getNext();
        }
        if (current.getNext() == node) {
            current.setNext(node.getNext());
            size--;
        }
    }

    /**
     * Sorts the list
     */
    public void sort() {
        if (head == null) {
            return;
        }
        SNode newHead = null;
        SNode current = head;
        while (current != null) {
            SNode next = current.getNext();
            if (newHead == null || current.getData() < newHead.getData()) {
                current.setNext(newHead);
                newHead = current;
            } else {
                SNode temp = newHead;
                while (temp.getNext() != null && current.getData() > temp.getNext().getData()) {
                    temp = temp.getNext();
                }
                current.setNext(temp.getNext());
                temp.setNext(current);
            }
            current = next;
        }
        head = newHead;
        SNode tail = newHead;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        this.tail = tail;
        size = 0;
        current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }
    }

    /**
     * Clears the list
     * 
     * @param node
     */
    public void clear(SNode node) {
        head = null;
        tail = null;
        size = 0;

    }

    /**
     * Prints the list that includes the size, sorted status, and the list
     */
    public void print() {
        System.out.println("Sorted Status for Singly Linked List: " + isSorted());
        System.out.println("Size for Singly Linked List: " + size);
        SNode current = head;
        System.out.print("List Contents for Singly Linked List: ");
        int getData = 0;
        while (current != null) {
            getData = current.getData();
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        if(current == null && getData == 0){
            System.out.println("Empty List");
        }
        System.out.println("\n");
    }
}
