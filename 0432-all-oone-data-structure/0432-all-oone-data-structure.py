class AllOne:

    def __init__(self):
        self.head = ListNode(0)
        self.tail = ListNode(0)
        self.head.next = self.tail
        self.tail.prev = self.head
        
        self.node_map = {}

    def inc(self, key: str) -> None:
        curr = self.node_map.get(key, self.head)
        if key in curr.keys:
            curr.keys.remove(key)
            
        nxt = curr.next
        if nxt.val != curr.val + 1:
            curr.insertAfter(ListNode(curr.val + 1))
            nxt = curr.next
            
        if len(curr.keys) == 0 and curr != self.head:
            curr.delete()
        
        nxt.keys.add(key)
        self.node_map[key] = nxt
        
    def dec(self, key: str) -> None:
        curr = self.node_map[key]
        curr.keys.remove(key)
        prev = curr.prev

       
        
        if curr.val == 1:
            if len(curr.keys) == 0:
                curr.delete()
            del self.node_map[key]
            return
        
        if prev.val != curr.val - 1:
            prev = ListNode(curr.val - 1)
            curr.insertBefore(prev)
        
        prev.keys.add(key)
        self.node_map[key] = prev
        if len(curr.keys) == 0:
            curr.delete()

    def getMaxKey(self) -> str:
        maxNode = self.tail.prev
        return next(iter(maxNode.keys)) if maxNode != self.head else ""

    def getMinKey(self) -> str:
        minNode = self.head.next
        return next(iter(minNode.keys)) if minNode != self.tail else ""
        
class ListNode:
    
    def __init__(self, val):
        self.val = val
        self.keys = set()
        self.next = None
        self.prev = None
        
    def insertAfter(self, node):
        nxt = self.next
        
        node.next = nxt
        nxt.prev = node
        
        self.next = node
        node.prev = self
        
    def insertBefore(self, node):
        prev = self.prev
        
        prev.next = node
        node.prev = prev
        
        node.next = self
        self.prev = node
        
    def delete(self):
        nxt = self.next
        prev = self.prev
        
        prev.next = nxt
        nxt.prev = prev

# Your AllOne object will be instantiated and called as such:
# obj = AllOne()
# obj.inc(key)
# obj.dec(key)
# param_3 = obj.getMaxKey()
# param_4 = obj.getMinKey()