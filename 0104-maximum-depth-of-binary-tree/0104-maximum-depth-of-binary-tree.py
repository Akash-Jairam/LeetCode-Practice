# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        res = 0
        if not root:
            return res
        
        queue = deque()
        queue.append(root)
        
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                
                if curr.left:
                    queue.append(curr.left)
                
                if curr.right:
                    queue.append(curr.right)
            res += 1
        
        return res