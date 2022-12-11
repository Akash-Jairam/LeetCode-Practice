# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findMax(self, node, res):
        if node == None:
            return 0
        
        find_left = max(0, self.findMax(node.left, res))
        find_right = max(0, self.findMax(node.right, res))
        res[0] = max(res[0], find_left + node.val + find_right)
        return node.val + max(find_left, find_right)
    
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        
        res = [-sys.maxsize - 1]
        self.findMax(root, res)
        return res[0]
        