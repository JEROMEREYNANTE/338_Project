class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class SinglyLinkedList:
    def __init__(self, head=None):
        self.head = head
        self.tail = head
        self.size = 0
        if head:
            self.size += 1

    def insert_head(self, node):
        node.next = self.head
        self.head = node
        if self.size == 0:
            self.tail = node
        self.size += 1

    def insert_tail(self, node):
        if self.size == 0:
            self.head = node
        else:
            self.tail.next = node
        self.tail = node
        self.size += 1

    def insert(self, node, position):
        if position <= 0:
            self.insert_head(node)
        elif position >= self.size:
            self.insert_tail(node)
        else:
            curr = self.head
            for i in range(position-1):
                curr = curr.next
            node.next = curr.next
            curr.next = node
            self.size += 1

    def sorted_insert(self, node):
        if self.size == 0 or node.data < self.head.data:
            self.insert_head(node)
        elif node.data >= self.tail.data:
            self.insert_tail(node)
        else:
            curr = self.head
            while curr.next and curr.next.data < node.data:
                curr = curr.next
            node.next = curr.next
            curr.next = node
            self.size += 1

    def search(self, node):
        curr = self.head
        while curr:
            if curr.data == node.data:
                return curr
            curr = curr.next
        return None

    def delete_head(self):
        if self.size == 0:
            return None
        node = self.head
        self.head = node.next
        if self.size == 1:
            self.tail = None
        self.size -= 1
        return node

    def delete_tail(self):
        if self.size == 0:
            return None
        if self.size == 1:
            node = self.head
            self.head = None
            self.tail = None
            self.size = 0
            return node
        curr = self.head
        while curr.next.next:
            curr = curr.next
        node = curr.next
        curr.next = None
        self.tail = curr
        self.size -= 1
        return node

    def delete(self, node):
        if self.size == 0:
            return None
        if self.head == node:
            return self.delete_head()
        if self.tail == node:
            return self.delete_tail()
        curr = self.head
        while curr.next and curr.next != node:
            curr = curr.next
        if not curr.next:
            return None
        curr.next = curr.next.next
        self.size -= 1
        return node

    def sort(self):
        if self.size < 2:
            return
        changed = True
        while changed:
            changed = False
            prev = None
            curr = self.head
            while curr.next:
                if curr.data > curr.next.data:
                    if prev:
                        prev.next = curr.next
                    else:
                        self.head = curr.next
                    temp = curr.next.next
                    curr.next.next = curr
                    curr.next = temp
                    prev = curr.next
                    changed = True
                else:
                    prev = curr
                    curr = curr.next

    def clear(self):
        self.head = None
        self.tail = None
        self.size = 0

    def print(self):
        curr = self.head
        while curr:
            print(curr.data)
            curr = curr.next


