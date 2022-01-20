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
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    
    public boolean validate(TreeNode node, Integer min, Integer max){
        if(node == null)
            return true;
        
        if((max != null && node.val >= max) || (min != null && node.val <= min))
            return false;
        
        boolean left = validate(node.left, min, node.val);
        boolean right = validate(node.right, node.val, max);
        
        return left && right;
    }
}