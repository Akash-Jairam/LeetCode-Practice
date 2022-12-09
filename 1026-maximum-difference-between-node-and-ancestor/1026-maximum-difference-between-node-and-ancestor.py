# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def helper(self, max_val, min_val, node):
        if node == None:
            return -1
        
        diff = max(abs(min_val - node.val) , abs(max_val - node.val))
        if node.val > max_val:
            max_val = node.val
        
        if node.val < min_val:
            min_val = node.val
        
        diff = max(diff, max(self.helper(max_val, min_val, node.right), self.helper(max_val, min_val, node.left)))
        return diff
        
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        return self.helper(root.val, root.val, root)
        