package main.java.mylib.datastructures;

import main.java.mylib.datastructures.linear.*;
import main.java.mylib.datastructures.nodes.DNode;
import main.java.mylib.datastructures.nodes.SNode;
import main.java.mylib.datastructures.nodes.TNode;
import main.java.mylib.datastructures.trees.AVL;
import main.java.mylib.datastructures.trees.BST;

public class test {
    public static void main(String[] args) {

        TNode roots = new TNode(10, 0, null, null, null);

        TNode leftChild = new TNode(5, 0, roots, null, null);
        roots.setLeft(leftChild);

        TNode rightChild = new TNode(15, 0, roots, null, null);
        roots.setRight(rightChild);

        System.out.println("Initial tree:");
        printTree(roots);

        // Modify the nodes
        roots.setData(20);
        leftChild.setBalance(-1);
        rightChild.setParent(leftChild);

        System.out.println("\nModified tree:");
        printTree(roots);

        TNode node1_ = new TNode();
        TNode node2_ = new TNode(5, 0, null, null, null);
        TNode node3_ = new TNode(10, 0, null, null, null);

        // Set parent and children for nodes
        node2_.setLeft(node1_);
        node2_.setRight(node3_);
        node1_.setParent(node2_);
        node3_.setParent(node2_);

        // Print node information
        node2_.print();

        // Print node data as string
        String dataAsString = node2_.toString();
        System.out.println("Node data as string: " + dataAsString);
        BST bst1 = new BST();
        System.out.println("BST1 (no arguments) root: " + bst1.getRoot()); // expect null

        // Test BST constructor with one argument
        BST bst2 = new BST(5);
        System.out.println("BST2 (one argument) root: " + bst2.getRoot().getData()); // expect 5

        // Test BST constructor with TNode argument
        TNode node_ = new TNode(10, 0, null, null, null);
        BST bst3 = new BST(node_);
        System.out.println("BST3 (TNode argument) root: " + bst3.getRoot().getData()); // expect 10

        // Test setRoot and getRoot methods
        TNode newRoot = new TNode(15, 0, null, null, null);
        bst1.setRoot(newRoot);
        System.out.println("BST1 new root: " + bst1.getRoot().getData()); // expect 15

        // Test insert method
        bst1.insert(8);
        bst1.insert(20);
        bst1.insert(3);
        bst1.insert(10);
        bst1.insert(16);
        bst1.insert(25);
        System.out.print("BST1 in-order traversal: ");
        bst1.printInOrder(); // expect 3 8 10 15 16 20 25

        // Test delete method
        bst1.delete(8);
        bst1.delete(16);
        System.out.print("BST1 in-order traversal after deletion: ");
        bst1.printInOrder(); // expect 3 10 15 20 25

        // Test search method
        TNode result1 = bst1.search(15);
        TNode result2 = bst1.search(30);
        System.out.println("BST1 search result for value 15: " + result1.getData()); // expect 15
        System.out.println("BST1 search result for value 30: " + result2); // expect null

        // Test printBF method
        System.out.println("BST1 breadth-first traversal:");
        bst1.printBF(); // expect 15 10 20 3 25

        TNode root = new TNode(10, 0, null, null, null);
        TNode node = new TNode(11, 0, null, null, null);

        AVL avl1 = new AVL();
        AVL avl2 = new AVL(7);
        avl1.insert(root);
        avl1.printInOrder();
        avl1.setRoot(node);
        avl1.printInOrder();
        avl1.insert(3);
        avl1.printInOrder();
        avl1.delete(3);
        avl1.printInOrder();
        avl1.getRoot();
        avl1.printInOrder();
        avl1.printBF();
        avl2.printInOrder();
        avl2.printBF();
        avl2.getRoot();
        avl2.insert(70);
        avl2.printBF();
        avl2.search(70);

        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        // Test the getData() method
        assert node1.getData() == 1;
        assert node2.getData() == 2;
        assert node3.getData() == 3;

        // Test the setNext() and getNext() methods
        node1.setNext(node2);
        node2.setNext(node3);

        assert node1.getNext() == node2;
        assert node2.getNext() == node3;
        assert node3.getNext() == null;

        DNode node4 = new DNode(1);
        DNode node5 = new DNode(2);
        DNode node6 = new DNode(3);

        // Test the getData() and setData() methods
        assert node4.getData() == 1;
        node4.setData(4);
        assert node4.getData() == 4;

        // Test the setNext() and getNext() methods
        node4.setNext(node5);
        node5.setNext(node6);
        assert node4.getNext() == node5;
        assert node5.getNext() == node6;
        assert node6.getNext() == null;

        // Test the setPrev() and getPrev() methods
        node5.setPrev(node4);
        node6.setPrev(node5);
        assert node4.getPrev() == null;
        assert node5.getPrev() == node4;
        assert node6.getPrev() == node5;

        SLL mySll = new SLL();
        SLL mySll1 = new SLL(node1);
        mySll1.clear(node1);
        mySll.insert(node2,0);
        mySll.insertHead(node3);
        mySll1.delete(node1);
        mySll1.deleteTail();
        mySll1.deleteHead();
        mySll1.insertTail(node2);
        System.out.println("Printing mySll1 for the first time");
        mySll1.print();
        System.out.println("Printing mySll for the first time");
        mySll.print();
        DLL myDll =  new DLL();
        DLL myDll1 = new DLL(node4);
        System.out.println("Printing myDll1 for the first time");
        myDll1.Print();
        System.out.println("Printing myDll for the first time");
        myDll.Print();
        myDll.InsertHead(node4);
        myDll.sortedInsert(node5);
        System.out.println("Printing myDll for the second time");
        myDll.Print();
        CSLL myCsll = new CSLL();
        myCsll.insertHead(node3);
        myCsll.insertHead(node3);
        System.out.println("Printing myCsll for the first time");
        myCsll.print();
        myCsll.insertTail(node1);
        System.out.println("Printing myCsll for the second time");
        myCsll.print();
        CDLL myCdll = new CDLL();
        myCdll.sortedInsert(node5);
        myCdll.InsertHead(node4);
        myCdll.Insert(node5,1);
        myCdll.InsertTail(node4);
        System.out.println("Printing myCdll for the first time");
        myCdll.Print();
        StackLL myStack = new StackLL();
        myStack.push(node1);
        System.out.println("Printing myStack for the first time");
        myStack.print();
        myStack.pop();
        System.out.println("Printing myStack for the second time");
        myStack.print();
        myStack.insert(node2,0);
        myStack.insertHead(node3);
        myStack.print();
        myStack.delete(node2);
        myStack.deleteHead();
        System.out.println("Printing myStack for the third time");
        myStack.print();
        QueueLL myQueue = new QueueLL();
        myQueue.insert(node2,0);
        System.out.println("Printing myQueue for the first time");
        myQueue.print();
        myQueue.insertHead(node3);
        System.out.println("Printing myQueue for the second time");
        myQueue.print();
        myQueue.enqueue(node1);
        System.out.println("Printing myQueue for the third time");
        myQueue.print();
        myQueue.dequeue();
        System.out.println("Printing myQueue for the fourth time");
        myQueue.print();
        myQueue.enqueue(node1);
        System.out.println("Printing myQueue for the fifth time");
        myQueue.print();
    }

    public static void printTree(TNode node) {
        if (node == null) {
            return;
        }

        node.print();
        printTree(node.getLeft());
        printTree(node.getRight());
    }
}
