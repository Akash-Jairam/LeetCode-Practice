# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        res = [0]
        
        self.dfs(root, float('-inf'), res)
        return res[0]
    
    def dfs(self, node, prevMax, res):
        if not node:
            return
        
        if node.val >= prevMax:
            res[0] += 1
        
        prevMax = max(prevMax, node.val)
        self.dfs(node.left, prevMax, res)
        self.dfs(node.right, prevMax, res)
        
        