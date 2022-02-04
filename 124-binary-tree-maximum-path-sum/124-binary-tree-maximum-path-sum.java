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
 * Create a global variable to track the max value
 * Perform dfs
 * Max path sum is negative, we disregard it and use 0
 * We will compare the value of node, the left path and the right path with our max and replace max if needed
 * Return the value of the current node + the greater of the left path and the right path.
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return max;
    }
    
    protected int findMax(TreeNode node){
        if(node == null)
            return 0;
        
        int leftMax = Math.max(0,findMax(node.left));
        int rightMax = Math.max(0,findMax(node.right));
        
        int maxCandidate = leftMax + rightMax + node.val;
        max = Math.max(max, maxCandidate);
        
        return node.val + Math.max(leftMax, rightMax);
    }
}