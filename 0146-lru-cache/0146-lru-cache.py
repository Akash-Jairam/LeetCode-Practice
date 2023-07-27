class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.head = Node(-1, -1)
        self.tail = Node(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.n_map = {}

    def get(self, key: int) -> int:
        node = self.n_map.get(key, None)
        if node:
            node.remove()
            self.head.insert(node)
            return node.val
        
        return -1

    def put(self, key: int, value: int) -> None:
        node = self.n_map.get(key, None)
        if node:
            node.val = value
            node.remove()
        else:
            if len(self.n_map) == self.capacity:
                last = self.tail.prev
                del self.n_map[last.key]
                last.remove()
            node = Node(key, value)
            self.n_map[key] = node
        self.head.insert(node)

class Node:
    
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.prev = None
        self.next = None
        
    def insert(self, node):
        nxt = self.next
        self.next = node
        node.prev = self
        node.next = nxt
        nxt.prev = node
        
    def remove(self):
        prev = self.prev
        nxt = self.next
        prev.next = nxt
        nxt.prev = prev
    

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)