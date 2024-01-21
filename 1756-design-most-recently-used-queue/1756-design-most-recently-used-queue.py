class MRUQueue:

    def __init__(self, n: int):
        self.head = Node(-1, None, None)
        it = self.head
        for i in range(1, n+1):
            it.next = Node(i, it, None)
            it = it.next
        self.tail = Node(-1, it, None)
        it.next = self.tail

    def fetch(self, k: int) -> int:
        it = self.head
        for i in range(k):
            it = it.next
        prev = it.prev
        nxt = it.next
        prev.next = nxt
        nxt.prev = prev
        prev = self.tail.prev
        prev.next = it
        it.prev = prev
        it.next = self.tail
        self.tail.prev = it
        return it.val
class Node:
    def __init__(self, val, prev, nxt):
        self.val = val
        self.prev = prev
        self.next = nxt

# Your MRUQueue object will be instantiated and called as such:
# obj = MRUQueue(n)
# param_1 = obj.fetch(k)