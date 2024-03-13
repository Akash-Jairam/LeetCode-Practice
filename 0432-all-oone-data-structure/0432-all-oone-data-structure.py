class ListNode:
    def __init__(self, val):
        self.keys = set()  # Holds the keys with the current count
        self.prev = None   # Previous ListNode in the doubly linked list
        self.next = None   # Next ListNode in the doubly linked list
        self.val = val     # The count value of this node

    def insertAfter(self, newNode):
        # Inserts newNode after this node
        newNode.prev = self
        newNode.next = self.next
        if self.next:
            self.next.prev = newNode
        self.next = newNode

    def insertBefore(self, newNode):
        # Inserts newNode before this node
        newNode.prev = self.prev
        newNode.next = self
        if self.prev:
            self.prev.next = newNode
        self.prev = newNode

    def delete(self):
        # Removes this node from the list, connecting previous and next nodes
        if self.prev:
            self.prev.next = self.next
        if self.next:
            self.next.prev = self.prev

class AllOne:        
    def __init__(self):
        self.head = ListNode(0)  # Sentinel node for the head
        self.tail = ListNode(float('inf'))  # Sentinel node for the tail
        self.head.next = self.tail
        self.tail.prev = self.head
        self.nodes = {}  # Maps keys to their corresponding ListNode

    def inc(self, key: str) -> None:
        if key in self.nodes:
            node = self.nodes[key]
            node.keys.remove(key)
        else:
            node = self.head

        if node.next.val != node.val + 1:
            newNode = ListNode(node.val + 1)
            node.insertAfter(newNode)
        else:
            newNode = node.next

        newNode.keys.add(key)
        self.nodes[key] = newNode

        if node != self.head and len(node.keys) == 0:
            node.delete()

    def dec(self, key: str) -> None:
        if key not in self.nodes:
            return

        node = self.nodes[key]
        node.keys.remove(key)

        if node.val == 1:
            if len(node.keys) == 0:
                node.delete()
            del self.nodes[key]
            return

        if node.prev.val != node.val - 1:
            newNode = ListNode(node.val - 1)
            node.insertBefore(newNode)
        else:
            newNode = node.prev

        newNode.keys.add(key)
        self.nodes[key] = newNode

        if len(node.keys) == 0:
            node.delete()

    def getMaxKey(self) -> str:
        if self.tail.prev != self.head:
            return next(iter(self.tail.prev.keys), "")
        return ""

    def getMinKey(self) -> str:
        if self.head.next != self.tail:
            return next(iter(self.head.next.keys), "")
        return ""

# Example of how to use the AllOne object
# obj = AllOne()
# obj.inc("key1")
# obj.dec("key1")
# maxKey = obj.getMaxKey()
# minKey = obj.getMinKey()
