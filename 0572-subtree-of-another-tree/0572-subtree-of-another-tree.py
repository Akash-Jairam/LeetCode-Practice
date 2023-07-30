# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        q = deque()
        q.append(root)
        
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                if curr.val == subRoot.val and self.isSameTree(curr, subRoot):
                    return True
                
                if curr.left:
                    q.append(curr.left)
                
                if curr.right:
                    q.append(curr.right)
        
        return False
    
    def isSameTree(self, p, q):
        if not p and not q:
            return True
        
        if p and q and p.val == q.val:
            return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
        
        return False