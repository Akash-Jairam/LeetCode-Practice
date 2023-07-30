# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int: 
        '''
            Use dfs 
            If a node is greater than the previous maxvalue, set the count to 1
            Update the previous max value if the node is greater than it
            Add the dfs of the left and right children to the count
        '''
        return self.dfs(root, float('-inf'))
       
    
    def dfs(self, node, prevMax):
        if not node:
            return 0
        
        res = 1 if node.val >= prevMax else 0
        
        prevMax = max(prevMax, node.val)
        res += self.dfs(node.left, prevMax)
        res += self.dfs(node.right, prevMax)
        return res
        
        