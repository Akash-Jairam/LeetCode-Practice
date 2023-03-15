# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def isCompleteTree(self, root: Optional[TreeNode]) -> bool:
        queue = deque()
        queue.append(root)
        
        while queue and queue[0]:
            curr = queue.popleft()
            queue.append(curr.left)
            queue.append(curr.right)
        
        while queue and not queue[0]:
            queue.popleft()
        
        return len(queue) == 0