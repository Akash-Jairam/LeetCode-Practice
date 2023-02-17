# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        def inOrder(node, vals):
            if not node:
                return
            
            inOrder(node.left, vals)
            vals.append(node.val)
            inOrder(node.right, vals)
        
        values = []
        inOrder(root, values)
        res = float('inf')
        
        for i in range(1, len(values)):
            res = min(res, values[i] - values[i-1])
        
        return res
            