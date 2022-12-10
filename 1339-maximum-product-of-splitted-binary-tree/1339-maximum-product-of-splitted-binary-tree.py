# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def find_sum(self, node):
        if node == None:
            return 0
        
        return self.find_sum(node.left) + node.val + self.find_sum(node.right)
    
    def find_max_product(self, node, res):
        if node == None:
            return 0
        
        left = self.find_max_product(node.left, res)
        right = self.find_max_product(node.right, res)
        curr = left + node.val + right
        res[1] = max(res[1], (res[0] - curr) * curr)
        return curr
    
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        
        total = self.find_sum(root)
        res = [total, 0]
        self.find_max_product(root, res)
        return (int)(res[1] % (1e9 + 7))
        
        