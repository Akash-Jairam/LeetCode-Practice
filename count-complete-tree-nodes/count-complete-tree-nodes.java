/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        // Create two references to the root, one for left traversal and one for right traversal
        // Since we know the binary tree is complete, we can traverse left and right until the right is null and increment our height accordingly
        // If the left pointer is also null, that means that the tree is full so we can just calculate using 2 ^ n -1
        // Else we count the left nodes , count the right nodes and add the sum of those two to 1 and return it
        TreeNode left = root, right = root;
        int height = 0;
        while(right != null){
            left = left.left;
            right = right.right;
            height++;
        }
        
        if(left == null)
            return (int) Math.pow(2, height)-1;
        
        return countNodes(root.left) + 1 + countNodes(root.right);
    }
}