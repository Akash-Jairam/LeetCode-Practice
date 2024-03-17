# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.dfs(root, float('-inf'), float('inf'))
    def dfs(self, node, currMin, currMax):
        if not node:
            return True
        
        if not currMin < node.val < currMax:
            return False
        
        validateLeft = self.dfs(node.left, currMin, node.val)
        validateRight = self.dfs(node.right, node.val, currMax)
        
        return validateLeft and validateRight