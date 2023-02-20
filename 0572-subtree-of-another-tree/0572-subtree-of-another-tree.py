# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def isSameTree(t1, t2):
            if not t1 and not t2:
                return True
            
            if not t1 or not t2:
                return False
            
            return isSameTree(t1.left, t2.left) and isSameTree(t1.right, t2.right) and t1.val == t2.val
        
        if not root and not subRoot:
            return True
        
        if not root or not subRoot:
            return False
        
        queue = deque()
        queue.append(root)
        res = False
        
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if curr.val == subRoot.val:
                    res = res or isSameTree(curr, subRoot)
                
                if res:
                    return True
                
                if curr.left:
                    queue.append(curr.left)
                    
                if curr.right:
                    queue.append(curr.right)
        
        return res
        
        
            