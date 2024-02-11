# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        res = []
        
        
        def dfs(node, res, visited):
            visited.append(str(node.val))

            if not node.left and not node.right:
                res.append("->".join(visited))
            
            if node.left:
                dfs(node.left, res, list(visited))
            
            if node.right:
                dfs(node.right, res, list(visited))
        
        dfs(root, res, [])
        
        return res
            