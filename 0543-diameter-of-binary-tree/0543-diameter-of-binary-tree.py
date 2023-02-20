# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        res = [0]
        
        def dfs(node, res):
            if not node:
                return -1
            
            left = dfs(node.left, res)
            right = dfs(node.right, res)
            
            res[0] = max(res[0], 2 + left + right)
            
            return 1 + max(left, right)
        
        dfs(root, res)
        return res[0]