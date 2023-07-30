# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        # Use bfs and keep track of the level count
        # Each time the inner loop executes, increment the level count
        # Return the level count at the end
        # TC: O(N) or O(V + E)
        # SC: O(N) or O(width) since the worst case is all of the nodes are directly under the root
        if not root:
            return 0
        
        q = deque()
        q.append(root)
        level = 0
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()

                if curr.left:
                    q.append((curr.left))

                if curr.right:
                    q.append((curr.right))
             
            level += 1
        
        return level
            
                
        
        