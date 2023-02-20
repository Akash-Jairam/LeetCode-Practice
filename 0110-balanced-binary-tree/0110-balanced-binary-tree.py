# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def dfs(node, height):
            if not node:
                return [0, True]
            
            left = dfs(node.left, height + 1)
            right = dfs(node.right, height + 1)
            height = 1 + max(left[0], right[0])
            if left[1] and right[1] and abs(left[0] - right[0]) <= 1:
                return [height, True]
            
            return [height, False]
        return dfs(root, 0)[1]
    
    
        
        