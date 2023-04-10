package main.java.mylib.datastructures.linear;
import main.java.mylib.datastructures.nodes.SNode;
/**
 * Queue class that extends the SLL class
 */
public class QueueLL extends SLL{
    /**
     * Default constructor
     */
    public QueueLL() {
        super();
    }

    /**
     * Overload constructor
     * @param head
     */
    public QueueLL(SNode head) {
        super(head);
    }

    /**
     * Enqueue a node at the tail of the list. Therefore, inserting a node at the tail of the list is the same as enqueueing a node.
     * @param node the node to be enqueued
     */
    public void enqueue(SNode node) {
        super.insertTail(node);
    }

    /**
     * Dequeue a node from the head of the list. Therefore, deleting a node from the head of the list is the same as dequeueing a node.
     */
    public void dequeue() {
        super.deleteHead();
    }

    @Override
    public void insertHead(SNode node) {
        // empty body, since this operation is not applicable to a queue
    }

    @Override
    public void insert(SNode node, int position) {
        // empty body, since this operation is not applicable to a queue
    }

    @Override
    public void sortedInsert(SNode node) {
        // empty body, since this operation is not applicable to a queue
    }

    @Override
    public void sort() {
        // empty body, since this operation is not applicable to a queue
    }
}
