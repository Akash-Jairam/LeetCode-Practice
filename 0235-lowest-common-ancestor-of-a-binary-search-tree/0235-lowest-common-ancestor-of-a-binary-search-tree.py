# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        lca = []
        self.findLCA(root, p, q, lca)
        return lca[0]
        
    def findLCA(self, node, p, q, lca):
        if not node or len(lca) > 0:
            return 0
        
        findLeft = self.findLCA(node.left, p, q, lca)
        findRight = self.findLCA(node.right, p, q, lca)
        findCurr = 1 if node.val == p.val or node.val == q.val else 0
        
        if findLeft + findRight + findCurr >= 2:
            lca.append(node)
        
        return findLeft + findRight + findCurr