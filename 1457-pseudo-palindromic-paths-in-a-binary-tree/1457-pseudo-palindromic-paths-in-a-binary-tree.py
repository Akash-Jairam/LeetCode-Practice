# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pseudoPalindromicPaths (self, root: Optional[TreeNode]) -> int:
        res = [0]
        nodes = set()
        
        def dfs(node, nodes, res):
            if not node:
                return
            
            if node.val in nodes:
                nodes.remove(node.val)
            else:
                nodes.add(node.val)
            
            if not node.left and not node.right and len(nodes) <= 1:
                res[0] += 1
            
            dfs(node.left, set(nodes), res)
            dfs(node.right, set(nodes), res)
        
        dfs(root, nodes, res)
        return res[0]
                