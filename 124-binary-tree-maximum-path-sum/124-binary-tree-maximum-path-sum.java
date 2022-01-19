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
    Integer max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }
    
    public int maxPath(TreeNode node){
        if(node == null)
            return 0;
        
        int left_gain = Math.max(maxPath(node.left),0);
        int right_gain = Math.max(maxPath(node.right),0);
        
        int newPath = node.val + left_gain + right_gain;
        max = Math.max(max, newPath);
        
        return node.val + Math.max(left_gain, right_gain);
    }
}