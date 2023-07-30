# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.dfs(root)[0]
    
    def dfs(self, node):
        if not node:
            return (True, 0)
        
        isLeftB, lh = self.dfs(node.left)
        isRightB, rh = self.dfs(node.right)
        
        return ((isLeftB and isRightB and abs(lh - rh) <= 1), 1 + max(lh, rh))