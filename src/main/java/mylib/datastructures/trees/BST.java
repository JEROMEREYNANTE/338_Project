package main.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Search Tree class
 */
public class BST {
    private TNode root;

    /**
     * Default constructor
     */
    public BST() {
        root = null;
    }

    /**
     * Overload constructor
     * 
     * @param val the data of the root node
     */
    public BST(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }

    /**
     * Overload constructor
     * 
     * @param obj the root node
     */
    public BST(TNode obj) {
        this.root = obj;
    }

    /**
     * setter for the root
     * 
     * @param root the root node
     */
    public void setRoot(TNode root) {
        this.root = root;
    }

    /**
     * getter for the root
     * 
     * @return the root node
     */
    public TNode getRoot() {
        return root;
    }

    /**
     * insert a data into the tree
     * 
     * @param val the data to be inserted
     */
    public void insert(int val) {
        TNode newNode = new TNode(val, 0, null, null, null);
        if (root == null) {
            root = newNode;
        } else {
            insert(root, newNode);
        }
    }

    /**
     * insert a node into the tree
     * 
     * @param node    the root of the tree
     * @param newNode the node to be inserted
     */
    private void insert(TNode node, TNode newNode) {
        if (newNode.getData() < node.getData()) {
            if (node.getLeft() == null) {
                node.setLeft(newNode);
            } else {
                insert(node.getLeft(), newNode);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(newNode);
            } else {
                insert(node.getRight(), newNode);
            }
        }
    }

    /**
     * insert a node into the tree
     * 
     * @param node the node to be inserted
     */
    public void insert(TNode node) {
        if (root == null) {
            root = node;
        } else {
            insert(root, node);
        }
    }

    /**
     * delete a node from the tree
     * 
     * @param val the value of the node to be deleted
     */
    public void delete(int val) {
        root = delete(root, val);
    }

    /**
     * delete a node from the tree
     * 
     * @param node the root of the tree
     * @param val  the value of the node to be deleted
     * @return the node that is deleted
     */
    private TNode delete(TNode node, int val) {
        if (node == null) {
            System.out.println("Value " + val + " is not in the tree.");
            return null;
        }
        if (val < node.getData()) {
            node.setLeft(delete(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(delete(node.getRight(), val));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                node = null;
            } else if (node.getLeft() == null) {
                node = node.getRight();
            } else if (node.getRight() == null) {
                node = node.getLeft();
            } else {
                TNode temp = findMin(node.getRight());
                node.setData(temp.getData());
                node.setRight(delete(node.getRight(), temp.getData()));
            }
        }
        return node;
    }

    /**
     * find the minimum node in the tree
     * 
     * @param node the root of the tree
     * @return the minimum node
     */
    private TNode findMin(TNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    /**
     * search a node in the tree
     * 
     * @param val the value of the node to be searched
     * @return the node that is searched
     */
    public TNode search(int val) {
        return search(root, val);
    }

    /**
     * search a node in the tree
     * 
     * @param node the root of the tree
     * @param val  the value of the node to be searched
     * @return the node that is searched
     */
    private TNode search(TNode node, int val) {
        if (node == null || node.getData() == val) {
            return node;
        }
        if (val < node.getData()) {
            return search(node.getLeft(), val);
        } else {
            return search(node.getRight(), val);
        }
    }

    /**
     * print the tree in order
     */
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    /**
     * print the tree in order
     * 
     * @param node the root of the tree
     */
    private void printInOrder(TNode node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrder(node.getRight());
        }
    }

    /**
     * print the tree in BF
     */
    public void printBF() {
        if (root == null) {
            return;
        }

        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TNode current = queue.remove();
                System.out.print(current.getData() + " ");

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }

                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }

            System.out.println(); // Print newline after each level
        }
    }
}
