# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        def dfs(node, p, q, lca):
            if not node:
                return 0
            
            findCurr = 1 if node.val == p.val or node.val == q.val else 0
                
            
            findLeft = dfs(node.left, p, q, lca)
            findRight = dfs(node.right, p, q, lca)
            total = findCurr + findLeft + findRight
            if total  >= 2 and not lca[0]:
                lca[0] = node
            
            return total
        
        res = [None]
        dfs(root, p, q, res)
        return res[0]
        