# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def closestKValues(self, root: Optional[TreeNode], target: float, k: int) -> List[int]:
        # TC = O(N + k)
        # SC = O(N)
        inOrder = [] 
        self.inOrderTraversal(root, inOrder)
        
        # Find insertion point
        # Alternative is to find the index with the smallest delta
        right = bisect_left(inOrder, target)
        left = right - 1
        
        res = []
        
        while len(res) < k:
            if right == len(inOrder) or abs(inOrder[left] - target) < abs(inOrder[right] - target):
                res.append(inOrder[left])
                left -= 1
            else:
                res.append(inOrder[right])
                right += 1
        
        return res
        
    def inOrderTraversal(self, node, nodes):
        if not node:
            return
        
        self.inOrderTraversal(node.left, nodes)
        nodes.append(node.val)
        self.inOrderTraversal(node.right, nodes)
    
    