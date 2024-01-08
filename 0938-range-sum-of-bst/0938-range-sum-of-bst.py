# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        q = deque()
        total = 0

        if root:
            q.append(root)
            
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if low <= curr.val <= high:
                    total += curr.val
                
                if curr.right and curr.val <= high:
                    q.append(curr.right)
                
                if curr.left and curr.val >= low:
                    q.append(curr.left)
        
        return total