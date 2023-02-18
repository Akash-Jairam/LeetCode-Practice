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
            
        newHead = Node(-1)
        newIt = newHead
        it = head
        
        while it:
            newIt.next = it.next
            if it.random:
                newIt.next.random = it.random.next
            
            newIt = newIt.next
            if it.next:
                it = it.next.next
            else:
                it = it.next
            
        return newHead.next