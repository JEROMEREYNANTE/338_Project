class TNode:
    def __init__(self, data=0, balance=0, parent=None, left=None, right=None):
        self.data = data
        self.balance = balance
        self.parent = parent
        self.left = left
        self.right = right

    # Setters
    def set_data(self, data):
        self.data = data

    def set_balance(self, balance):
        self.balance = balance

    def set_left(self, left):
        self.left = left

    def set_right(self, right):
        self.right = right

    def set_parent(self, parent):
        self.parent = parent

    # Getters
    def get_data(self):
        return self.data

    def get_balance(self):
        return self.balance

    def get_left(self):
        return self.left

    def get_right(self):
        return self.right

    def get_parent(self):
        return self.parent

    # Print method
    def print_node(self):
        print("Data: {}, Balance: {}".format(self.data, self.balance))

    # ToString method
    def __str__(self):
        return str(self.data)
