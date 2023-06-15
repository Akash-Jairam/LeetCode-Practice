# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        q = deque()
        q.append(root)
        level = 1
        max_sum = float('-inf')
        res = -1
        while q:
            curr_sum = 0
            size = len(q)
            
            for _ in range(size):
                curr = q.popleft()
                curr_sum += curr.val
                
                if curr.right:
                    q.append(curr.right)
                    
                if curr.left:
                    q.append(curr.left)
            
            if curr_sum > max_sum:
                max_sum = curr_sum
                res = level
            level += 1
        
        return res