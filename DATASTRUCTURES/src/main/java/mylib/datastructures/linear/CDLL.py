class Node:
    def __init__(self, value):
        self.value = value
        self.prev = None
        self.next = None

class CircularDoublyLinkedList:
    def __init__(self):
        self.head = None

    def is_empty(self):
        return self.head is None

    def add_to_tail(self, value):
        new_node = Node(value)
        if self.is_empty():
            self.head = new_node
            new_node.next = self.head
            new_node.prev = self.head
        else:
            current_node = self.head
            while current_node.next != self.head:
                current_node = current_node.next
            current_node.next = new_node
            new_node.prev = current_node
            new_node.next = self.head
            self.head.prev = new_node

    def remove_from_tail(self):
        if self.is_empty():
            return None
        elif self.head.next == self.head:
            removed_node = self.head
            self.head = None
        else:
            current_node = self.head
            while current_node.next.next != self.head:
                current_node = current_node.next
            removed_node = current_node.next
            current_node.next = self.head
            self.head.prev = current_node
        return removed_node.value

    def add_to_head(self, value):
        new_node = Node(value)
        if self.is_empty():
            self.head = new_node
            new_node.next = self.head
            new_node.prev = self.head
        else:
            new_node.next = self.head
            new_node.prev = self.head.prev
            self.head.prev.next = new_node
            self.head.prev = new_node
            self.head = new_node

    def remove_from_head(self):
        if self.is_empty():
            return None
        elif self.head.next == self.head:
            removed_node = self.head
            self.head = None
        else:
            removed_node = self.head
            self.head.prev.next = self.head.next
            self.head.next.prev = self.head.prev
            self.head = self.head.next
        return removed_node.value

    def search(self, value):
        current_node = self.head
        while current_node is not None:
            if current_node.value == value:
                return True
            current_node = current_node.next
            if current_node == self.head:
                break
        return False

    def size(self):
        count = 0
        current_node = self.head
        while current_node is not None:
            count += 1
            current_node = current_node.next
            if current_node == self.head:
                break
        return count

    def to_list(self):
        lst = []
        current_node = self.head
        while current_node is not None:
            lst.append(current_node.value)
            current_node = current_node.next
            if current_node == self.head:
                break
        return lst
