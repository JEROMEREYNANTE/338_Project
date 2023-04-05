package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class DLL {
    private DNode head;
    private DNode tail;
    private int size;

    // Constructor
    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    // Overload constructor
    public DLL(DNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;

    }
    public void InsertTail(DNode node){
        if(tail == null){
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size++;
    }
    public void InsertHead(DNode node){
        if(head == null){
            head = node;
            tail = node;
        } else {
            head.setPrev(node);
            node.setNext(head);
            head = node;
        }
        size++;
    }
    public void Insert(DNode node, int position){
        if(position < 0 || position > size){
            throw new IndexOutOfBoundsException();
        }
        if(position == 0){
            InsertHead(node);
        } else if(position == size){
            InsertTail(node);
        } else {
            DNode current = head;
            for(int i = 0; i < position; i++){
                current = current.getNext();
            }
            node.setNext(current.getNext());
            node.setPrev(current);
            current.getNext().setPrev(node);
            current.setNext(node);
            size++;

        }
    }

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
    }

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
    public void DeleteHead(){
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

    public void DeleteTail(){
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


    public void Delete(DNode node){
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

    public void clear(DNode node) {
        if (node != null) {
            clear(node.getNext());
            node.setNext(null);
            node.setPrev(null);
        }
    }

    public void Print(){
        System.out.println("Sorted: " + isSorted());
        System.out.println("Size: " + size);
        DNode current = head;
        System.out.print("List: ");
        while(current != null){
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();

    }
}
