package main.java.mylib.datastructures.linear;
import main.java.mylib.datastructures.nodes.SNode;
public class StackLL extends SLL{
    public StackLL() {
        super();
    }

    public void push(SNode node) {
        super.insertHead(node);
    }

    public SNode pop() {
        SNode node = super.head;
        super.deleteHead();
        return node;
    }

    /*
    public SNode peek() {
        return super.head;
    }
    */

    @Override
    public void insertTail(SNode node) {
        // Override with empty body, not applicable to stacks
    }

    @Override
    public void insert(SNode node, int position) {
        // Override with empty body, not applicable to stacks
    }

    @Override
    public void sortedInsert(SNode node) {
        // Override with empty body, not applicable to stacks
    }

    @Override
    public SNode search(SNode node) {
        // Override with empty body, not applicable to stacks
        return null;
    }

    @Override
    public void deleteTail() {
        // Override with empty body, not applicable to stacks
    }

    @Override
    public void delete(SNode node) {
        // Override with empty body, not applicable to stacks
    }

    @Override
    public void sort() {
        // Override with empty body, not applicable to stacks
    }
}
