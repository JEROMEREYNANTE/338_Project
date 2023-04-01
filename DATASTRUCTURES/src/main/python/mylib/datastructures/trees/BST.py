from datastructures.nodes.TNode import TNode


class BST:
    def __init__(self):
        self.root = None

    def __init__(self, val):
        self.root = TNode(val, 0, None, None, None)

    def __init__(self, obj):
        self.root = obj

    def set_root(self, node):
        self.root = node

    def get_root(self):
        return self.root
    def insert(self, val):
        if self.root is None:
            self.root = TNode(val, 0, None, None, None)
        else:
            self._insert(val, self.root)

    def _insert(self, val, node):
        if val < node.data:
            if node.left is None:
                node.left = TNode(val, 0, node, None, None)
                self._update_balance(node, 1)
            else:
                self._insert(val, node.left)
        else:
            if node.right is None:
                node.right = TNode(val, 0, node, None, None)
                self._update_balance(node, -1)
            else:
                self._insert(val, node.right)

    def insert_node(self, node):
        if self.root is None:
            self.root = node
        else:
            self._insert_node(node, self.root)

    def _insert_node(self, node, current):
        if node.data < current.data:
            if current.left is None:
                current.left = node
                node.parent = current
                self._update_balance(current, 1)
            else:
                self._insert_node(node, current.left)
        else:
            if current.right is None:
                current.right = node
                node.parent = current
                self._update_balance(current, -1)
            else:
                self._insert_node(node, current.right)

    def Delete(self, val):
        current = self.root
        parent = None

        # Search for the node with the given value
        while current != None and current.data != val:
            parent = current
            if val < current.data:
                current = current.left
            else:
                current = current.right

        # If node not found, print a statement and return
        if current == None:
            print(f"Value {val} not found in the tree.")
            return

        # If node has no children, delete it and update parent's child pointer
        if current.left == None and current.right == None:
            if current == self.root:
                self.root = None
            elif current == parent.left:
                parent.left = None
            else:
                parent.right = None
            del current

        # If node has one child, bypass it and update parent's child pointer
        elif current.left == None or current.right == None:
            child = current.left if current.left != None else current.right
            if current == self.root:
                self.root = child
            elif current == parent.left:
                parent.left = child
            else:
                parent.right = child
            del current

        # If node has two children, find the successor and replace the node's data
        else:
            successor = current.right
            while successor.left != None:
                successor = successor.left
            current.data = successor.data
            self.Delete(successor.data)

    def Search(self, val):
        current = self.root
        while current != None:
            if current.data == val:
                return current
            elif val < current.data:
                current = current.left
            else:
                current = current.right
        return None

    def printInOrder(self):
        self._printInOrderHelper(self.root)
        print()

    def _printInOrderHelper(self, node):
        if node != None:
            self._printInOrderHelper(node.left)
            print(node.data, end=' ')
            self._printInOrderHelper(node.right)
    def printBF(self):
        pass


