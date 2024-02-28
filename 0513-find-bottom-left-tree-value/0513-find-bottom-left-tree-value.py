# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        q = deque()
        q.append(root)
        left = 0
        
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                if _ == 0:
                    left = curr.val
                    
                if curr.left:
                    q.append(curr.left)
                
                if curr.right:
                    q.append(curr.right)
        
        
        return left