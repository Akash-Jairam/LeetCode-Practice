class LRUCache:
    class Node:
        def __init__(self, key, value):
            self.key = key
            self.val = value
            self.prev = None
            self.next = None
        
        def insertAt(self, node):
            nxt = self.next
            self.next = node
            node.next = nxt
            
            nxt.prev = node
            node.prev = self
        
        def remove(self):
            nxt, prev = self.next, self.prev
            prev.next = nxt
            nxt.prev = prev
            
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        
        self.head = self.Node(-1, -1)
        self.tail = self.Node(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.head.prev = self.tail
        self.tail.next = self.head
        
    def get(self, key: int) -> int:
        node = self.cache.get(key, None)
        
        if node:
            node.remove()
            self.head.insertAt(node)
            
        
        return node.val if node else -1
        

    def put(self, key: int, value: int) -> None:
        if self.capacity == len(self.cache) and key not in self.cache:
            last = self.tail.prev
            del self.cache[last.key]
            last.remove()
        
        
        node = self.Node(key,value)
        
        if key in self.cache:
            node = self.cache[key]
            node.val = value
            node.remove()
            
        
        self.cache[key] = node
        self.head.insertAt(node)


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)