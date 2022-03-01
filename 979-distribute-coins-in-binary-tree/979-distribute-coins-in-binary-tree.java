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
        // Create an array to store our steps
        // Call our dfs function
        int[] steps = new int[] {0};
        distribute(root, steps);
        return steps[0];
    }
    
    public int distribute(TreeNode node, int[] steps){
        // If the node is null, return 0
        if(node == null)
            return 0;
        // Find the number of excess coins / coins needed from both the left side and the right side
        // Add to our array, the sum of the absolute values obtained from the left side and the right side
        int findLeft = distribute(node.left, steps);
        int findRight = distribute(node.right, steps);
        // Return the count at the current node + the left side count + the right side count - 1 (indicates that the current node either has to keep 1 coin or needs 1 coin)
        steps[0] += Math.abs(findLeft) + Math.abs(findRight);
        return node.val + findLeft + findRight - 1;
    }
}