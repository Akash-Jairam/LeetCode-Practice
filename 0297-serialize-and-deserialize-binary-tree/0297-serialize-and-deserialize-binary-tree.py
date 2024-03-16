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
        
        curr = [str(root.val)]
        curr.append(self.serialize(root.left))
        curr.append(self.serialize(root.right))
        return ','.join(curr)
    
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        split = data.split(',')
        q = deque()
        q.extend(split)
        return self.helper(q)
    
    def helper(self, q):
        if len(q) == 0:
            return
        
        curr = q.popleft()
        if curr == 'null':
            return
        
        currNode = TreeNode(int(curr))
        currNode.left = self.helper(q)
        currNode.right = self.helper(q)
        
        return currNode
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))