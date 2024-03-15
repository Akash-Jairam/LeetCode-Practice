# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def closestValue(self, root: Optional[TreeNode], target: float) -> int:
        inOrder = []
        self.inOrderTraversal(root, inOrder)
        
        min_delta = abs(inOrder[0] - target)
        closest = inOrder[0]
        
        for i in range(1, len(inOrder)):
            if abs(inOrder[i] - target) < min_delta:
                min_delta = abs(inOrder[i] - target)
                closest = inOrder[i]
        
        return closest
        
    
    def inOrderTraversal(self, node, nodes):
        if not node:
            return
        
        self.inOrderTraversal(node.left, nodes)
        nodes.append(node.val)
        self.inOrderTraversal(node.right, nodes)
        