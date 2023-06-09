package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

/**
 * Doubly Linked List class
 */
public class DLL {
    private DNode head;
    private DNode tail;
    private int size;

    /**
     * Default constructor
     */
    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Overload constructor
     * 
     * @param head
     */
    public DLL(DNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;

    }

    /**
     * Insert a node at the tail of the list
     * 
     * @param node
     */
    public void InsertTail(DNode node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size++;
    }

    /**
     * Insert a node at the head of the list
     * 
     * @param node
     */
    public void InsertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            size++;
        } else {
            head.setPrev(node);
            node.setNext(head);
            head = node;
        }

        node.setNext(null);
    }

    /**
     * Insert a node at a specific position in the list
     * 
     * @param node
     * @param position
     */
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
            node.setNext(current.getNext());
            node.setPrev(current);
            current.getNext().setPrev(node);
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
    public void sortedInsert(DNode node) {
        if (!isSorted()) {
            Sort();
        }
        DNode current = head;
        DNode prev = null;
        while (current != null && current.getData() < node.getData()) {
            prev = current;
            current = current.getNext();
        }
        if (prev == null) {
            InsertHead(node);
        } else {
            node.setNext(current);
            node.setPrev(prev);
            prev.setNext(node);
            current.setPrev(node);
            size++;
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
        DNode current = head;
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
    public DNode search(DNode node) {
        DNode current = head;
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
    public void DeleteHead() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        }
        size--;
        if (head == null) {
            tail = null;
        }
    }

    /**
     * Deletes the tail of the list
     */
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
        tail.setNext(null);
        size--;
    }

    /**
     * Deletes a node from the list
     * 
     * @param node
     */
    public void Delete(DNode node) {
        if (head == null) {
            return;
        }
        if (head == node) {
            head = node.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
            size--;
            return;
        }
        if (tail == node) {
            tail = node.getPrev();
            if (tail != null) {
                tail.setNext(null);
            } else {
                head = null;
            }
            size--;
            return;
        }
        DNode prev = node.getPrev();
        DNode next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
    }

    /**
     * Sorts the list
     */
    public void Sort() {
        if (head == null) {
            return;
        }
        DNode newHead = null;
        DNode current = head;
        while (current != null) {
            DNode next = current.getNext();
            if (newHead == null || current.getData() < newHead.getData()) {
                current.setNext(newHead);
                current.setPrev(null);
                newHead = current;
            } else {
                DNode temp = newHead;
                while (temp.getNext() != null && current.getData() > temp.getNext().getData()) {
                    temp = temp.getNext();
                }
                current.setNext(temp.getNext());
                current.setPrev(temp);
                if (temp.getNext() != null) {
                    temp.getNext().setPrev(current);
                }
                temp.setNext(current);
            }
            current = next;
        }
        head = newHead;
        DNode tail = newHead;
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
    public void clear(DNode node) {
        if (node != null) {
            clear(node.getNext());
            node.setNext(null);
            node.setPrev(null);
        }
    }

    /**
     * Prints the list that includes the size, sorted status, and the list
     */
    public void Print() {
        System.out.println("Sorted Status for Doubly Linked List: " + isSorted());
        System.out.println("Size for Doubly Linked List: " + size);
        DNode current = head;
        System.out.print("List Contents for Doubly Linked List: ");
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
