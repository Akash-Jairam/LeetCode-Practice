# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def isEvenOddTree(self, root: Optional[TreeNode]) -> bool:
        even = True
        q = deque([root])
        
        while q:
            prev = float('-inf') if even else float('inf')
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                
                if curr.left:
                    q.append(curr.left)
                    
                if curr.right:
                    q.append(curr.right)
                
                if even and (curr.val % 2 == 0 or curr.val <= prev):
                    return False
                elif not even and (curr.val % 2 == 1 or curr.val >= prev):
                    return False
                
                prev = curr.val
            even = not even
        
        return True