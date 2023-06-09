package main.java.mylib.datastructures;

import main.java.mylib.datastructures.linear.*;
import main.java.mylib.datastructures.nodes.DNode;
import main.java.mylib.datastructures.nodes.SNode;
import main.java.mylib.datastructures.nodes.TNode;
import main.java.mylib.datastructures.trees.AVL;
import main.java.mylib.datastructures.trees.BST;

public class App {
    public static void main(String[] args) {
        

        System.out.println("\n\nModule 1\n"); 
        SNode Snode1 = new SNode(1);
        SNode Snode2 = new SNode(2);
        SNode Snode3 = new SNode(3);

        // Test the getData() method
        assert Snode1.getData() == 1;
        assert Snode2.getData() == 2;
        assert Snode3.getData() == 3;

        // Test the setNext() and getNext() methods
        Snode1.setNext(Snode2);
        Snode2.setNext(Snode3);

        assert Snode1.getNext() == Snode2;
        assert Snode2.getNext() == Snode3;
        assert Snode3.getNext() == null;

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
        SLL mySll1 = new SLL(Snode1);
        mySll1.clear(Snode1);
        mySll.insert(Snode2,0);
        mySll.insertHead(Snode3);
        mySll1.delete(Snode1);
        mySll1.deleteTail();
        mySll1.deleteHead();
        mySll1.insertTail(Snode2);
        System.out.println("Printing mySll1 for the first time");
        mySll1.print();
        System.out.println("Printing mySll for the first time");
        mySll.print();
        DLL myDll =  new DLL();
        DLL myDll1 = new DLL(node4);
        myDll.Insert(node5,0);
        myDll.Insert(node4,0);
        System.out.println("Printing myDll1 for the first time");
        myDll1.Print();
        System.out.println("Printing myDll for the first time");
        myDll.Print();
        myDll.InsertHead(node4);
        myDll.sortedInsert(node5);
        System.out.println("Printing myDll for the second time");
        myDll.Print();
        CSLL myCsll = new CSLL();
        myCsll.insertHead(Snode3);
        myCsll.insertHead(Snode3);
        System.out.println("Printing myCsll for the first time");
        myCsll.print();
        myCsll.insertTail(Snode1);
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
        myStack.push(Snode1);
        System.out.println("Printing myStack for the first time");
        myStack.print();
        myStack.pop();
        System.out.println("Printing myStack for the second time");
        myStack.print();
        myStack.insert(Snode2,0);
        myStack.insertHead(Snode3);
        myStack.print();
        myStack.delete(Snode2);
        myStack.deleteHead();
        System.out.println("Printing myStack for the third time");
        myStack.print();
        QueueLL myQueue = new QueueLL();
        myQueue.insert(Snode2,0);
        System.out.println("Printing myQueue for the first time");
        myQueue.print();
        myQueue.insertHead(Snode3);
        System.out.println("Printing myQueue for the second time");
        myQueue.print();
        myQueue.enqueue(Snode1);
        System.out.println("Printing myQueue for the third time");
        myQueue.print();
        myQueue.dequeue();
        System.out.println("Printing myQueue for the fourth time");
        myQueue.print();
        myQueue.enqueue(Snode1);
        System.out.println("Printing myQueue for the fifth time");
        myQueue.print();
        
        
        
        System.out.println("\n\nModule 2\n");
        TNode root = new TNode(10, 0, null, null, null);

        TNode leftChild = new TNode(5, 0, root, null, null);
        root.setLeft(leftChild);

        TNode rightChild = new TNode(15, 0, root, null, null);
        root.setRight(rightChild);

        System.out.println("Initial tree:");
        printTree(root);

        // Modify the nodes
        root.setData(20);
        leftChild.setBalance(-1);
        rightChild.setParent(leftChild);

        System.out.println("\nModified tree:");
        printTree(root);

        TNode node1 = new TNode();
        TNode node2 = new TNode(5, 0, null, null, null);
        TNode node3 = new TNode(10, 0, null, null, null);

        // Set parent and children for nodes
        node2.setLeft(node1);
        node2.setRight(node3);
        node1.setParent(node2);
        node3.setParent(node2);

        // Print node information
        node2.print();

        // Print node data as string
        String dataAsString = node2.toString();
        System.out.println("Node data as string: " + dataAsString);
        BST bst1 = new BST();
        System.out.println("BST1 (no arguments) root: " + bst1.getRoot()); // expect null

        // Test BST constructor with one argument
        BST bst2 = new BST(5);
        System.out.println("BST2 (one argument) root: " + bst2.getRoot().getData()); // expect 5

        // Test BST constructor with TNode argument
        TNode node = new TNode(10, 0, null, null, null);
        BST bst3 = new BST(node);
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

        TNode roots = new TNode(10, 0, null, null, null);
        TNode nodes = new TNode(11, 0, null, null, null);

        AVL avl1 = new AVL();
        AVL avl2 = new AVL(7);
        avl1.insert(roots);
        avl1.printInOrder();
        avl1.setRoot(nodes);
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