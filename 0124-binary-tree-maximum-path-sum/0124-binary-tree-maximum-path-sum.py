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
        
    def dfs(self, root, res):
        if not root:
            return 0
        
        left = max(0, self.dfs(root.left, res))
        right = max(0, self.dfs(root.right, res))
        res[0] = max(res[0], root.val + left + right)
        return root.val + max(left, right)