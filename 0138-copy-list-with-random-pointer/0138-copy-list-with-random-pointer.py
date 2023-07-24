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
        n_map = {}
        it = head
        
        while it:
            n_map[it] = Node(it.val)
            it = it.next
        
        res = Node(-1)
        resIt = res
        it = head
        
        while it:
            resIt.next = n_map[it]
            if it.random:
                resIt.next.random = n_map[it.random]
            resIt = resIt.next
            it = it.next
        
        return res.next