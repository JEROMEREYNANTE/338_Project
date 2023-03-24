from typing import Any


class CSNode:
    """
    Circular Singly Linked List node class
    """
    def __init__(self, data: Any = None, next: 'CSNode' = None):
        self.data = data
        self.next = next


class CircularSinglyLL:
    """
    Circular Singly Linked List class
    """
    def __init__(self, head: CSNode = None, size: int = 0):
        self.head = head
        self.size = size

        if head is not None:
            # Loop the head to reference itself
            head.next = head

    def is_empty(self) -> bool:
        """
        Checks if the list is empty
        """
        return self.head is None

    def get_size(self) -> int:
        """
        Returns the size of the list
        """
        return self.size

    def insert_head(self, node: CSNode) -> None:
        """
        Inserts a node at the head of the list
        """
        if self.is_empty():
            node.next = node
        else:
            tail = self.head
            while tail.next != self.head:
                tail = tail.next

            node.next = self.head
            tail.next = node

        self.head = node
        self.size += 1

    def insert_tail(self, node: CSNode) -> None:
        """
        Inserts a node at the tail of the list
        """
        if self.is_empty():
            node.next = node
            self.head = node
        else:
            tail = self.head
            while tail.next != self.head:
                tail = tail.next

            node.next = self.head
            tail.next = node
            
        self.size += 1

    def insert(self, node: CSNode) -> None:
        """
        Inserts a node at the tail of the list
        """
        self.insert_tail(node)

    def search(self, node: CSNode) -> CSNode:
        """
        Searches for a node in the list
        """
        if self.is_empty():
            return None

        curr = self.head
        while curr.next != self.head:
            if curr.data == node.data:
                return curr
            curr = curr.next

        return None
    
    def delete_head(self) -> CSNode:
        """
        Deletes the head node of the list
        """
        if self.is_empty():
            return None

        tail = self.head
        while tail.next != self.head:
            tail = tail.next

        node = self.head
        tail.next = node.next
        self.head = node.next
        self.size -= 1

        return node
    
    def delete_tail(self) -> CSNode:
        """
        Deletes the tail node of the list
        """
        if self.is_empty():
            return None

        tail = self.head
        while tail.next.next != self.head:
            tail = tail.next

        node = tail.next
        tail.next = self.head
        self.size -= 1

        return node
    
    