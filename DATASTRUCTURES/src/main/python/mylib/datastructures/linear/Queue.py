from SLL import SinglyLinkedList


class Queue(SinglyLinkedList):
    def __init__(self):
        super().__init__()

    def enqueue(self, data):
        self.insert_tail(data)

    def dequeue(self):
        return self.delete_head()

    def is_empty(self):
        return super().is_empty()

    def insert_head(self, node):
        pass

    def delete_head(self):
        if self.is_empty():
            return None
        head = self.head
        self.head = head.next
        self.size -= 1
        return head.data

    def insert_tail(self, node):
        super().insert_tail(node)

    def delete_tail(self):
        pass

    def get_head(self):
        return super().get_head()

    def get_tail(self):
        return super().get_tail()

    def print(self):
        super().print()
