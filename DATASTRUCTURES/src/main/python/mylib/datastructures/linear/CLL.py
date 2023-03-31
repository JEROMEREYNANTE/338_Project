class CircularSinglyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def insert_head(self, node):
        if not self.head:
            self.head = node
            self.tail = node
            node.next = self.head
        else:
            node.next = self.head
            self.head = node
            self.tail.next = self.head
        self.size += 1

    def insert_tail(self, node):
        if not self.head:
            self.insert_head(node)
        else:
            self.tail.next = node
            node.next = self.head
            self.tail = node
            self.size += 1

    def insert(self, node, position):
        if position <= 0:
            self.insert_head(node)
        elif position >= self.size:
            self.insert_tail(node)
        else:
            current = self.head
            for _ in range(position - 1):
                current = current.next
            node.next = current.next
            current.next = node
            self.size += 1

    def sorted_insert(self, node):
        if not self.head:
            self.insert_head(node)
        elif node.data < self.head.data:
            self.insert_head(node)
        elif node.data > self.tail.data:
            self.insert_tail(node)
        else:
            current = self.head
            while current.next != self.head and current.next.data < node.data:
                current = current.next
            node.next = current.next
            current.next = node
            self.size += 1

    def search(self, node):
        current = self.head
        for _ in range(self.size):
            if current.data == node.data:
                return current
            current = current.next
        return None

    def delete_head(self):
        if not self.head:
            return None
        elif self.size == 1:
            node = self.head
            self.head = None
            self.tail = None
        else:
            node = self.head
            self.head = node.next
            self.tail.next = self.head
        self.size -= 1
        return node

    def delete_tail(self):
        if not self.head:
            return None
        elif self.size == 1:
            node = self.head
            self.head = None
            self.tail = None
        else:
            current = self.head
            while current.next != self.tail:
                current = current.next
            node = self.tail
            current.next = self.head
            self.tail = current
        self.size -= 1
        return node

    def delete(self, node):
        if not self.head:
            return None
        elif node == self.head:
            return self.delete_head()
        elif node == self.tail:
            return self.delete_tail()
        else:
            current = self.head
            while current.next != node:
                current = current.next
            current.next = node.next
            self.size -= 1
            return node

    def sort(self):
        if not self.head:
            return None
        else:
            current = self.head
            for i in range(self.size):
                current_inner = current.next
                for j in range(i + 1, self.size):
                    if current.data > current_inner.data:
                        current.data, current_inner.data = current_inner.data, current.data
                    current_inner = current_inner.next
                current = current.next

    def clear(self):
        self.head = None
        self.tail = None
        self.size = 0

    def print(self):
        if not self.head:
            return None
        else:
            current = self.head
            print(f"List size: {self.size}")
            print("List content:", end=" ")
            while current.next != self.head:
                print(current.data, end=" ")
                current = current.next
            print(current.data)
