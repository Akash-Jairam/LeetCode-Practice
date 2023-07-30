# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        diameter = [0]
        self.traverse(root, diameter)
        return diameter[0]
        
    
    def traverse(self, node, diameter):
        if not node:
            return -1
        
        leftHeight = self.traverse(node.left, diameter)
        rightHeight = self.traverse(node.right, diameter)
        
        diameter[0] = max(diameter[0], leftHeight + rightHeight + 2)
        return 1 + max(leftHeight, rightHeight)