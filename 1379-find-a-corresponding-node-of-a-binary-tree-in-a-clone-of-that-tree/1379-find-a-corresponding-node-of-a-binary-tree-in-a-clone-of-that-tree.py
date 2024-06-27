# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        return self.dfs(cloned, target)
        
    def dfs(self, node, target):
        if not node:
            return
        
        if node.val == target.val:
            return node
        
        l, r = self.dfs(node.left, target), self.dfs(node.right, target)
        if l:
            return l
        
        if r:
            return r
        