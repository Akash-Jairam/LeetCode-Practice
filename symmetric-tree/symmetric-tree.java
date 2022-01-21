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
        
        if(left == null || right == null)
            return false;
        
        boolean checkOneSide = check(left.left, right.right);
        boolean checkOtherSide = check(left.right, right.left);
        
        return (left.val == right.val) && checkOneSide && checkOtherSide;
    }
    
    
}