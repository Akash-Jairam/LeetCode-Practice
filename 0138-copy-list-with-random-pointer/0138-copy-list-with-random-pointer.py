"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        it = head
        
        while it:
            nxt = it.next
            it.next = Node(it.val, nxt)
            it = nxt
        
        res = Node(-1)
        it2 = res
        it = head
        
        while it:
            it2.next = it.next
            if it.random:
                it2.next.random = it.random.next
            
            it = it.next.next
            it2 = it2.next
        
        return res.next