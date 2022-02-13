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
        // Create two pointers that point to the root and call them left and right
        // While the right pointer is not equal to null, make the left pointer go left and the right pointer go right. Increment the height tracker accordingly
        // If the left pointer is equal to null, the tree is fully populated so we return the height
        // Else we add find the sum of countnodes left and right and add one before returning it
        TreeNode left = root;
        TreeNode right = root;
        int height = 0;
        while(right != null){
            left = left.left;
            right = right.right;
            ++height;
        }
        
        if(left == null)
            return (int) Math.pow(2, height)-1;
        else
            return countNodes(root.left)  + countNodes(root.right) + 1;
    }

}