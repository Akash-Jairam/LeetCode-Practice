# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        res = [0]
        self.dfs(root, res)
        return res[0]
    
    def dfs(self, node, res):
        if not node:
            return 0
        
        l = self.dfs(node.left, res)
        r = self.dfs(node.right, res)
        
        res[0] += abs(l) + abs(r)
        return node.val + l + r - 1