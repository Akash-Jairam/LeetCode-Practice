# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        n_list = []
        
        def traverse(node, node_list):
            if not node:
                return
            
            traverse(node.left, node_list)
            node_list.append(node.val)
            traverse(node.right, node_list)
        
        traverse(root, n_list)
        diff = float('inf')
        for i in range(1, len(n_list)):
            diff = min(diff, abs(n_list[i] - n_list[i-1]))
        
        return diff
        