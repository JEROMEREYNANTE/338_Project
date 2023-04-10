package main.java.mylib.datastructures.linear;
import main.java.mylib.datastructures.nodes.SNode;
/**
 * Stack class that extends the SLL class
 */
public class StackLL extends SLL{
    /**
     * Default constructor
     */
    public StackLL() {
        super();
    }

    /**
     * push a node onto the stack. Therefore inserting it at the head of the list
     * @param node node to be pushed onto the stack
     */
    public void push(SNode node) {
        super.insertHead(node);
    }

    /**
     * pop a node off the stack. Therefore deleting it from the head of the list
     * @return node popped off the stack
     */
    public SNode pop() {
        SNode node = super.head;
        super.deleteHead();
        return node;
    }


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
