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
        # Create a copy of each node and place it between the original node and the original's next pointer
        # Now create a dummy list to hold the result with its own it
        # Iterate through the original list again and append the new nodes to the dummy list
        # If a node has a random pointer, update the new node's pointer to point to the random's '.next'
        # Return the resulting list
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