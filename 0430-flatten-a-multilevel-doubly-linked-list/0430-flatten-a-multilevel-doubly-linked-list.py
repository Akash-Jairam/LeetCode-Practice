"""
# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""

class Solution:
    def flatten(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return head
        stack = []
        dummy = Node(-1, None, head, None)
        prev = dummy
        it = head
        
        while it:
            it.prev = prev
            if it.child:
                child = it.child
                nxt = it.next
                it.next = child
                while child.next:
                    stack.append(child)
                    child = child.next
                child.next = nxt
                if nxt:
                    nxt.prev = child
                it.child = None
            
            if it.next:
                stack.append(it.next)
            prev = it
            it = it.next
        
        head.prev = None
        return head
                