class AllOne:        
    def __init__(self):
        self.head = ListNode(0)
        self.tail = ListNode(float('inf'))
        self.head.next = self.tail
        self.tail.prev = self.head
        self.nodes = {}
        
    def inc(self, key: str) -> None:
        node = self.nodes.get(key, self.head)
        if key in node.keys:
            node.keys.remove(key)
        if node.next.val != node.val + 1:
            node.insertAfter(ListNode(node.val + 1))
            
        node = node.next
        node.keys.add(key)
        self.nodes[key] = node


        if node.prev != self.head and len(node.prev.keys) == 0:
            node.prev.delete()

    def dec(self, key: str) -> None:
        if key not in self.nodes:
            return  # Key does not exist, so we can't decrement it

        node = self.nodes[key]
        node.keys.remove(key)

        if node.val == 1:
            # If after removal, the node is empty and it's not the head, delete it
            if len(node.keys) == 0:
                node.delete()
            # Remove the key from the nodes dictionary if its count is 1 and now has no keys
            del self.nodes[key]
            return

        # If the previous node does not match the decremented value, create a new node with the decremented value
        if node.prev.val != node.val - 1:
            newNode = ListNode(node.val - 1)
            node.insertBefore(newNode)
        else:
            newNode = node.prev

        newNode.keys.add(key)
        self.nodes[key] = newNode  # Correctly update the reference to the new node

        # If the current node is empty after removing the key, delete it
        if len(node.keys) == 0:
            node.delete()

    def getMaxKey(self) -> str:
        print(self.tail.prev.val)
        return next(iter(self.tail.prev.keys)) if len(self.tail.prev.keys) else ""

    def getMinKey(self) -> str:
        return next(iter(self.head.next.keys)) if len(self.head.next.keys) else ""


class ListNode:
        def __init__(self, val):
            self.keys = set()
            self.prev = None
            self.next = None
            self.val = val
        
        def insertAfter(self, node):
            nxt = self.next
            
            self.next = node
            node.prev = self
            
            node.next = nxt
            nxt.prev = node
        
        def insertBefore(self, node):
            prev = self.prev
            
            prev.next = node
            node.prev = prev
            
            node.next = self
            self.prev = node
            
        def delete(self):
            nxt, prev = self.next, self.prev
            prev.next = nxt
            nxt.prev = prev
            
        def getKeys(self):
            return self.keys

# Your AllOne object will be instantiated and called as such:
# obj = AllOne()
# obj.inc(key)
# obj.dec(key)
# param_3 = obj.getMaxKey()
# param_4 = obj.getMinKey()