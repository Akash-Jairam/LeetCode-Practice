# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        zig = True
        queue, res = deque(), []
        if not root:
            return res
        queue.append(root)
        
        while queue:
            size = len(queue)
            curr_list = []
            for i in range(size):
                curr = queue.popleft()
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
                if zig:
                    curr_list.append(curr.val)
                else:
                    curr_list = [curr.val] + curr_list
            zig = not zig
            res.append(curr_list)
        
        return res
                    
