# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        q = deque()
        q.append((root, 1))
        res = 1
        while q:
            size = len(q)
            for _ in range(size):
                curr, v = q.popleft()
              
                res = max(res, v)

                if curr.left:
                    q.append((curr.left, v + 1))

                if curr.right:
                    q.append((curr.right, v + 1))
                
        
        return res
            
                
        
        