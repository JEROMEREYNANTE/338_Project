package main.java.mylib.datastructures.trees;

import main.java.mylib.datastructures.nodes.TNode;

/**
 * AVL Tree class that extends BST
 */
public class AVL extends BST {
    private TNode root;

    public AVL() {
        this.root = null;
    }

    public AVL(int val) {
        this.root = new TNode(val,0,null,null,null);
    }

    public AVL(TNode obj) {
        if (obj == null) {
            this.root = null;
        } else {
            this.root = obj;
            balanceTree();
        }
    }

    public void setRoot(TNode root) {
        this.root = root;
        if (root != null) {
            balanceTree();
        }
    }

    public TNode getRoot() {
        return this.root;
    }

    @Override
    public void insert(int val) {
        super.insert(val);
        balanceTree();
    }

    @Override
    public void insert(TNode node) {
        super.insert(node);
        balanceTree();
    }

    @Override
    public void delete(int val) {
        TNode nodeToDelete = search(val);
        if (nodeToDelete == null) {
            System.out.println("Value " + val + " not found in the tree.");
            return;
        }
        super.delete(nodeToDelete.getData()); // needs to be fixed
        balanceTree();
    }

    private void balanceTree() {
        if (root != null) {
            root = balanceTree(root);
        }
    }

    private TNode balanceTree(TNode node) {
        if (node == null) {
            return null;
        }
        if (getHeight(node.getLeft()) - getHeight(node.getRight()) > 1) {
            if (getHeight(node.getLeft().getLeft()) >= getHeight(node.getLeft().getRight())) {
                node = rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        } else if (getHeight(node.getRight()) - getHeight(node.getLeft()) > 1) {
            if (getHeight(node.getRight().getRight()) >= getHeight(node.getRight().getLeft())) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }
        updateHeight(node);
        return node;
    }

    private TNode rotateLeft(TNode node) {
        TNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    private TNode rotateRight(TNode node) {
        TNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    private int getHeight(TNode node) {
        if (node == null) {
            return -1;
        } else {
            return node.getBalance();
        }
    }

    private void updateHeight(TNode node) {
        if (node != null) {
            node.setBalance(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        }
    }

}
