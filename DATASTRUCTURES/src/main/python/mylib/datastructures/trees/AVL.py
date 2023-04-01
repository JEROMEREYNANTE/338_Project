from typing import Union
from datastructures.nodes.TNode import TNode


class AVL:
    def __init__(self, root: TNode = None):
        self.root = root

    def insert(self, val: int):
        new_node = TNode(val)
        if self.root is None:
            self.root = new_node
            return
        node, parent = self.root, None
        while node is not None:
            parent = node
            if val < node.data:
                node = node.left
            elif val > node.data:
                node = node.right
            else:
                return  # value already exists
        new_node.parent = parent
        if val < parent.data:
            parent.left = new_node
        else:
            parent.right = new_node
        self._rebalance(new_node)

    def insert_node(self, node: TNode):
        if self.root is None:
            self.root = node
            return
        parent = None
        current = self.root
        while current is not None:
            parent = current
            if node.data < current.data:
                current = current.left
            elif node.data > current.data:
                current = current.right
            else:
                return  # value already exists
        node.parent = parent
        if node.data < parent.data:
            parent.left = node
        else:
            parent.right = node
        self._rebalance(node)

    def delete(self, val: int):
        node = self.search(val)
        if node is None:
            print(f"Value {val} not found in tree")
            return
        if node.left is None or node.right is None:
            child = node.left or node.right
            if child is None:
                child = TNode()
            if node.parent is None:
                self.root = child
            elif node == node.parent.left:
                node.parent.left = child
            else:
                node.parent.right = child
            child.parent = node.parent
            node.parent = node.left = node.right = None
            self._rebalance(child)
        else:
            pred = node.left
            while pred.right is not None:
                pred = pred.right
            node.data = pred.data
            self.delete(pred.data)

    def search(self, val: int) -> Union[TNode, None]:
        node = self.root
        while node is not None:
            if node.data == val:
                return node
            elif val < node.data:
                node = node.left
            else:
                node = node.right
        return None

    def print_in_order(self):
        def _print_in_order(node):
            if node is not None:
                _print_in_order(node.left)
                print(node.data, end=' ')
                _print_in_order(node.right)

        _print_in_order(self.root)
        print()

