# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        '''
            We need to use dfs to find the diameter
            The dfs will return the max height of a given of the current node (1 + leftHeight, rightHeight)
            The diameter = max(diameter, maxLeft + maxRight)
            TC: O(N)
            SC: O(N)
        '''
        diameter = [0]
        self.dfs(root, diameter)
        
        return diameter[0]
    def dfs(self, node, diameter):
        if not node:
            return 0
        
        leftHeight = self.dfs(node.left, diameter)
        rightHeight = self.dfs(node.right, diameter)
        
        diameter[0] = max(diameter[0], leftHeight + rightHeight)
        return 1 + max(leftHeight, rightHeight)