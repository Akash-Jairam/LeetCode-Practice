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
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    
    public boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        else if(left == null || right == null)
            return false;
        
        
        boolean val = true;
        
        if(left.val != right.val)
            val = false;
        
        
        boolean leftval = check(left.left, right.right);
        boolean rightval = check(left.right, right.left);
        
        
        
        return val && leftval && rightval;
        
    }
    
    
}