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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return helper(root, targetSum, 0);
    }
    
    public boolean helper(TreeNode node, int target, int curr){
        if(node == null) return false;
        
        if(node.left == null && node.right == null)
            return node.val + curr == target;
        
        curr += node.val;
        return helper(node.left, target, curr) || helper(node.right, target, curr);
    }
}