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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return max;
    }
    
    public int findMaxPath(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int leftMax = Math.max(findMaxPath(node.left), 0);
        int rightMax = Math.max(findMaxPath(node.right), 0);
    
        int maxCandidate = node.val + leftMax + rightMax;
        
        max = Math.max(max, maxCandidate);
        
        return node.val + Math.max(leftMax, rightMax);
    }
}