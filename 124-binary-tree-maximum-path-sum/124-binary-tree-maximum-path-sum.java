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
        
        int leftGain = Math.max(maxPath(node.left),0);
        int rightGain = Math.max(maxPath(node.right),0);
        
        int maxCandidate = node.val + rightGain + leftGain;
        max = Math.max(max, maxCandidate);
        
        return node.val + Math.max(leftGain, rightGain);
    }
}