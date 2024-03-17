# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        lca = []
        
        
        
        self.dfs(root, lca, p, q)
        return lca[0]
            
    def dfs(self, curr, lca, p, q):
            if not curr:
                return 0
            
            res = 1 if curr.val == p.val or curr.val == q.val else 0
            findLeft = self.dfs(curr.left, lca, p, q)
            findRight = self.dfs(curr.right, lca, p, q)
            
            if res + findLeft + findRight >= 2 and len(lca) == 0:
                lca.append(curr)
            
            return res + findLeft + findRight