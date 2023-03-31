from SLL import SinglyLinkedList


class DoublyLinkedList(SinglyLinkedList):
    def __init__(self, head=None):
        super().__init__(head)
        self.tail = head

    def insert_head(self, node):
        if not self.head:
            self.head = node
            self.tail = node
        else:
            node.next = self.head
            self.head.prev = node
            self.head = node

    def insert_tail(self, node):
        if not self.tail:
            self.head = node
            self.tail = node
        else:
            node.prev = self.tail
            self.tail.next = node
            self.tail = node

    def insert(self, node, position):
        if position == 0:
            self.insert_head(node)
        elif position >= self.size():
            self.insert_tail(node)
        else:
            current_node = self.head
            for i in range(position):
                current_node = current_node.next
            node.next = current_node
            node.prev = current_node.prev
            current_node.prev.next = node
            current_node.prev = node

    def delete_head(self):
        if not self.head:
            return None
        deleted_node = self.head
        self.head = deleted_node.next
        if self.head:
            self.head.prev = None
        else:
            self.tail = None
        deleted_node.next = None
        return deleted_node

    def delete_tail(self):
        if not self.tail:
            return None
        deleted_node = self.tail
        self.tail = deleted_node.prev
        if self.tail:
            self.tail.next = None
        else:
            self.head = None
        deleted_node.prev = None
        return deleted_node

    def delete(self, node):
        if not node:
            return None
        if node == self.head:
            return self.delete_head()
        if node == self.tail:
            return self.delete_tail()
        node.prev.next = node.next
        node.next.prev = node.prev
        node.next = None
        node.prev = None
        return node

    def clear(self):
        self.head = None
        self.tail = None

    def print(self):
        current_node = self.head
        print(f"List length: {self.size()}")
        print(f"Sorted status: {self.is_sorted()}")
        print("List content:")
        while current_node:
            print(current_node.data, end=" ")
            current_node = current_node.next
        print()
