# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        res = [float('-inf')]
        self.dfs(root, res)
        return res[0]
    
    def dfs(self, node, res):
        if not node:
            return 0
        
        left = max(0, self.dfs(node.left, res))
        right = max(0, self.dfs(node.right, res))
        res[0] = max(res[0], left + node.val + right)
        
        return node.val + max(left, right)