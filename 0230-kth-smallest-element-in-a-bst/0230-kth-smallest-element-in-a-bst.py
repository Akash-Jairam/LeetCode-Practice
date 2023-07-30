# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        pre = []
        self.preOrder(root, pre)
        return pre[k-1]
    
    def preOrder(self, root, nodes):
        if not root:
            return
        
        self.preOrder(root.left, nodes)
        nodes.append(root.val)
        self.preOrder(root.right, nodes)