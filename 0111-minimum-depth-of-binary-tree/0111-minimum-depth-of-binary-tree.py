# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        level = 1
        
        q = deque()
        q.append(root)
        
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                
                if not curr.left and not curr.right:
                    return level
            level += 1
        
        return level
     
        
        
        
        