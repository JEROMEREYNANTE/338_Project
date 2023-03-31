from SLL import SinglyLinkedList


class Stack(SinglyLinkedList):
    def __init__(self):
        super().__init__()

    def push(self, data):
        self.insert_head(data)

    def pop(self):
        return self.delete_head()

    def peek(self):
        return self.get_head()

    def is_empty(self):
        return super().is_empty()

    def insert_head(self, node):
        pass

    def insert_tail(self, node):
        pass

    def delete_head(self):
        if self.is_empty():
            return None
        head = self.head
        self.head = head.next
        self.size -= 1
        return head.data

    def delete_tail(self):
        pass

    def get_head(self):
        return super().get_head()

    def get_tail(self):
        pass

    def print(self):
        super().print()
