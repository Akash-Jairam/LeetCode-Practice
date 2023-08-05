# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        '''
            The first node is always preorder[0] since preorder starts with the current node 
            Find the index of that node in the inorder traversal. This lets us know how many nodes to the left and right of this node
            The preorder array lets us know what the current node is and the inorder array helps us to find the left and right nodes based on the position of the current node that we got from the preorder array
            The left subtree of this node will be recursive call to buildTree(preorder[1: mid + 1], inorder[:mid])
            The right subtree will be a recursive call to buildTree(preorder[mid+1:], inorder[mid+1:])
        '''
        if not preorder or not inorder:
            return None
        
        node = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
        node.left = self.buildTree(preorder[1:mid + 1], inorder[:mid])
        node.right = self.buildTree(preorder[mid + 1:], inorder[mid + 1:])
        return node