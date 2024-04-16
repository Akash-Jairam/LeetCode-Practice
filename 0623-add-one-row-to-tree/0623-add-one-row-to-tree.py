# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def addOneRow(self, root: Optional[TreeNode], val: int, depth: int) -> Optional[TreeNode]:
        d = 1
        if depth == 1:
            return TreeNode(val, root)
        q = deque([root])
        
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                if d == depth - 1:
                    left = curr.left
                    right = curr.right
                    curr.left = TreeNode(val, left)
                    curr.right = TreeNode(val, None, right)
                else:
                    if curr.left:
                        q.append(curr.left)

                    if curr.right:
                        q.append(curr.right)

                
                
            d += 1
            if d >= depth:
                break
            
        return root
                