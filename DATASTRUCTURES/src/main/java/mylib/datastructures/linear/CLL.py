class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None

class CircularSinglyLinkedList:
    def __init__(self):
        self.head = None
        self.size = 0

    def insert_head(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            new_node.next = self.head
        else:
            current = self.head
            while current.next != self.head:
                current = current.next
            current.next = new_node
            new_node.next = self.head
            self.head = new_node
        self.size += 1

    def insert_tail(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            new_node.next = self.head
        else:
            current = self.head
            while current.next != self.head:
                current = current.next
            current.next = new_node
            new_node.next = self.head
        self.size += 1

    def insert(self, data, position):
        if position < 0 or position > self.size:
            raise IndexError("Insertion index out of range")
        if position == 0:
            self.insert_head(data)
        elif position == self.size:
            self.insert_tail(data)
        else:
            new_node = Node(data)
            current = self.head
            for i in range(position-1):
                current = current.next
            new_node.next = current.next
            current.next = new_node
            self.size += 1

    def search(self, data):
        if not self.head:
            return None
        current = self.head
        while current.next != self.head:
            if current.data == data:
                return current
            current = current.next
        if current.data == data:
            return current
        return None

    def delete_head(self):
        if not self.head:
            raise Exception("List is empty")
        if self.size == 1:
            self.head = None
        else:
            current = self.head
            while current.next != self.head:
                current = current.next
            current.next = self.head.next
            self.head = self.head.next
        self.size -= 1

    def delete_tail(self):
        if not self.head:
            raise Exception("List is empty")
        if self.size == 1:
            self.head = None
        else:
            current = self.head
            while current.next.next != self.head:
                current = current.next
            current.next = self.head
        self.size -= 1

    def delete(self, data):
        if not self.head:
            raise Exception("List is empty")
        if self.head.data == data:
            self.delete_head()
        else:
            current = self.head
            while current.next != self.head:
                if current.next.data == data:
                    current.next = current.next.next
                    self.size -= 1
                    return
                current = current.next
            raise ValueError("Node not found in list")

    def clear(self):
        self.head = None
        self.size = 0

    def print(self):
        if not self.head:
            print("List is empty")
        else:
            current = self.head
            print(f"List size: {self.size}")
            print("List content:", end=" ")
            while current.next != self.head:
                print(current.data, end=" ")
                current = current.next
            print(current.data)
