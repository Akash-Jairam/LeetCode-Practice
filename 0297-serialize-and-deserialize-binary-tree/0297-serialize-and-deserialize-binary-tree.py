# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return "null"
        
        res =[str(root.val)]
        res.append(self.serialize(root.left))
        res.append(self.serialize(root.right))
        return ",".join(res)
        
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        q = deque(data.split(","))
        return self.helper(q)
    def helper(self, queue):
        if not queue:
            return None
        curr = queue.popleft()
        if curr == "null":
            return None
        
        curr = TreeNode(int(curr))
        curr.left = self.helper(queue)
        curr.right = self.helper(queue)
        return curr

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))