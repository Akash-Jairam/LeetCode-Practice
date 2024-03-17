class LRUCache:

    def __init__(self, capacity: int):
        self.c = capacity
        self.head = Node(-1, -1)
        self.tail = Node(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head
        
        self.nodes = {}

    def get(self, key: int) -> int:
        if key not in self.nodes:
            return -1
        
        curr = self.nodes[key]
        curr.delete()
        self.tail.insertBefore(curr)
        return curr.value
        

    def put(self, key: int, value: int) -> None:
        if key in self.nodes:
            curr = self.nodes[key]
            curr.value = value
            curr.delete()
            self.tail.insertBefore(curr)
        else:
            if len(self.nodes) == self.c:
                curr = self.head.next
                del self.nodes[curr.key]
                curr.delete()
                
            curr = Node(key, value)
            self.nodes[key] = curr
            self.tail.insertBefore(curr)
            
        
class Node:
    
    def __init__(self, key, value):
        self.key = key
        self.value = value
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


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)