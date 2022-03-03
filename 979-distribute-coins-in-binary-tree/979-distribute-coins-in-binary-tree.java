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
    public int distributeCoins(TreeNode root) {
        // Create an array of size zero that will hold our steps
        // Make a call to our distribution function and pass our array and the root as params
        int[] steps = new int[] {0};
        distribute(root, steps);
        
        return steps[0];
    }
    
    public int distribute(TreeNode node, int[] steps){
        if(node == null)
            return 0;
        
        // Make a recursive call to node.left and node.right
        // Add the absolute of the values returned by those recursive calls to steps
        // Return whatever we find from the left and the right plus node.val -1 (-1 to account for the current node having or needing one coin)
        int findLeft = distribute(node.left, steps);
        int findRight = distribute(node.right, steps);
        steps[0] += Math.abs(findLeft) + Math.abs(findRight);
        
        return findLeft + findRight + node.val - 1;
    }
}