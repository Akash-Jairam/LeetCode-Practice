"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
from collections import deque
class Solution:
    def maxDepth(self, root: 'Node') -> int:
        if not root:
            return 0
    
        q = deque([root])
        depth = 0
        
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                for child in curr.children:
                    q.append(child)
            depth += 1
        
        return depth