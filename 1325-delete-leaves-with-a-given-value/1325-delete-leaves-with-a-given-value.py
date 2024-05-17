# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def removeLeafNodes(self, root: Optional[TreeNode], target: int) -> Optional[TreeNode]:
        dummy = TreeNode(-1, root)
        self.dfs(dummy, target)
        return dummy.left
    
    def dfs(self, node, val):
        if not node:
            return
        
        l = self.dfs(node.left, val)
        r = self.dfs(node.right, val)
        
        if l:
            node.left = None
        
        if r:
            node.right = None
        
        
        if not node.left and not node.right:
            if node.val == val:
                return True
        
        return False
