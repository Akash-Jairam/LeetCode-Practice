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
        
        res = Node(-1, head)
        resIt = res
        it = head
        
        while it:
            resIt.next = it.next
            if it.random:
                resIt.next.random = it.random.next
            
            it = it.next.next
            resIt = resIt.next
        
        return res.next