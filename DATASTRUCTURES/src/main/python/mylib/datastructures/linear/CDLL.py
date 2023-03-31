class CircularDoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def is_empty(self):
        return self.size == 0

    def __len__(self):
        return self.size

    def append(self, data):
        node = self.Node(data)
        if self.is_empty():
            self.head = node
            self.tail = node
            node.prev = node
            node.next = node
        else:
            node.prev = self.tail
            node.next = self.head
            self.tail.next = node
            self.head.prev = node
            self.tail = node
        self.size += 1

    def prepend(self, data):
        node = self.Node(data)
        if self.is_empty():
            self.head = node
            self.tail = node
            node.prev = node
            node.next = node
        else:
            node.prev = self.tail
            node.next = self.head
            self.tail.next = node
            self.head.prev = node
            self.head = node
        self.size += 1

    def insert(self, data, index):
        if index < 0 or index > self.size:
            raise IndexError("Index out of range")
        if index == 0:
            self.prepend(data)
        elif index == self.size:
            self.append(data)
        else:
            node = self.Node(data)
            curr = self.head
            for i in range(index-1):
                curr = curr.next
            node.prev = curr
            node.next = curr.next
            curr.next.prev = node
            curr.next = node
            self.size += 1

    def remove(self, data):
        if self.is_empty():
            raise ValueError("List is empty")
        curr = self.head
        while curr:
            if curr.data == data:
                if self.size == 1:
                    self.head = None
                    self.tail = None
                elif curr == self.head:
                    self.head = curr.next
                    curr.next.prev = self.tail
                    self.tail.next = self.head
                elif curr == self.tail:
                    self.tail = curr.prev
                    curr.prev.next = self.head
                    self.head.prev = self.tail
                else:
                    curr.prev.next = curr.next
                    curr.next.prev = curr.prev
                self.size -= 1
                return
            curr = curr.next
        raise ValueError("Data not found in list")

    def index(self, data):
        if self.is_empty():
            raise ValueError("List is empty")
        curr = self.head
        for i in range(self.size):
            if curr.data == data:
                return i
            curr = curr.next
        raise ValueError("Data not found in list")

    def clear(self):
        self.head = None
        self.tail = None
        self.size = 0

    def __iter__(self):
        curr = self.head
        for i in range(self.size):
            yield curr.data
            curr = curr.next

    def __str__(self):
        return '[' + ' <-> '.join([str(item) for item in self]) + ']'
