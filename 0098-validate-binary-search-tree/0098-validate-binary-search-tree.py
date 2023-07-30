# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.dfs(root, float('inf'), float('-inf'))
    
    def dfs(self, node, prevMax, prevMin):
        if not node:
            return True
        
        if not prevMin < node.val< prevMax:
            return False
        
        return True and self.dfs(node.left, node.val, prevMin) and self.dfs(node.right, prevMax, node.val)