# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        '''
            Use dfs to check the whether the trees are the same
            If both trees are None, return True
            Else if either tree is None, return False
            Now we use dfs to see if the left sides are equal
            Then do dfs to see if the right sides are equal
            Finally, return whether both sides of both sides are equal and whether the value of the current nodes are the same
            TC: O(N) or O(V + E)
            SC: O(N) or O(V + E)
        '''
        if not p and not q:
            return True
        
        if not p or not q:
            return False
        
        isLeftSame = self.isSameTree(p.left, q.left)
        isRightSame = self.isSameTree(p.right, q.right)
        
        return p.val == q.val and isLeftSame and isRightSame