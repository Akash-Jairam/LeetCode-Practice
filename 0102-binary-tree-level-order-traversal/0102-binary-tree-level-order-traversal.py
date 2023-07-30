# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        '''
            Use bfs to traverse the tree level by level
            Create a list for each level and append the values of that level
            After we finish traversing a given level, append the list to our result list and traverse the other levels
            
            TC: O(N) or O(V + E)
            SC: O(N) or O(V + E)
        '''
        res = []
        if not root:
            return res
        
        q = deque()
        q.append(root)
        
        while q:
            size = len(q)
            level = []
            for _ in range(size):
                curr = q.popleft()
                level.append(curr.val)
                
                if curr.left:
                    q.append(curr.left)
                    
                if curr.right:
                    q.append(curr.right)
            res.append(level)        
        return res
