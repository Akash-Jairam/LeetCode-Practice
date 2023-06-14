# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        q = deque()
        
        q.append(root)
        vals = []
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                vals.append(curr.val)
                
                if curr.left:
                    q.append(curr.left)
                
                if curr.right:
                    q.append(curr.right)
               
        min_val = float('inf')
        
        for i in range(len(vals) - 1):
            for j in range(i + 1, len(vals)):
                min_val = min(min_val, abs(vals[i] - vals[j]))
        
        return min_val