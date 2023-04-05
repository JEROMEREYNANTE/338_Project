package main.java.mylib.datastructures.linear;
import main.java.mylib.datastructures.nodes.SNode;
public class QueueLL extends SLL{
    public QueueLL() {
        super();
    }

    public QueueLL(SNode head) {
        super(head);
    }

    public void enqueue(SNode node) {
        super.insertTail(node);
    }

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
