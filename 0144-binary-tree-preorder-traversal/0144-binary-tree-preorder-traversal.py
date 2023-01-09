# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        def helper(node, res):
            if node == None:
                return
            
            res.append(node.val)
            helper(node.left, res)
            helper(node.right, res)
        
        res = []
        helper(root, res)
        return res