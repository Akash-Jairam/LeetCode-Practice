# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def closestKValues(self, root: Optional[TreeNode], target: float, k: int) -> List[int]:
        inOrder = []
        self.dfs(root, inOrder)
        
        left = bisect_left(inOrder, target) - 1
        right = left + 1
        res = []
        
        while len(res) < k:
            if right == len(inOrder) or abs(inOrder[left] - target) < abs(inOrder[right] - target):
                res.append(inOrder[left])
                left -= 1
            else:
                res.append(inOrder[right])
                right += 1
        
        return res
    
    def dfs(self, node, nodes):
        if not node: 
            return
        
        self.dfs(node.left, nodes)
        nodes.append(node.val)
        self.dfs(node.right, nodes)