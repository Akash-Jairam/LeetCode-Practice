# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def evaluateTree(self, root: Optional[TreeNode]) -> bool:
        return self.dfs(root)
        
    def dfs(self, node):
        if not node:
            return True
        
        if node.val == 2:
            return self.dfs(node.left) or self.dfs(node.right)
        elif node.val == 3:
            return self.dfs(node.left) and self.dfs(node.right)
        
        return node.val
        
        
            