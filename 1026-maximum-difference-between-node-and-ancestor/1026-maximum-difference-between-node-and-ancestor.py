# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        def helper(node, res, currMax, currMin):
            if not node:
                return 
            
            currMax = max(currMax, node.val)
            currMin = min(currMin, node.val)
            res[0] = max(res[0], abs(currMax - node.val))
            res[0] = max(res[0], abs(currMin - node.val))
            helper(node.left, res, currMax, currMin)
            helper(node.right, res, currMax, currMin)
            
        
        res = [0]
        helper(root, res, 0, float('inf'))
        return res[0]