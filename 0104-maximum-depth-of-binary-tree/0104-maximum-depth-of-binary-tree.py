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
        q.append(root)
        res = 0
        
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                
                if curr.left:
                    q.append(curr.left)
                    
                if curr.right:
                    q.append(curr.right)
            res += 1
        
        return res