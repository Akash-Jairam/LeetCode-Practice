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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q);
    }
    
    public boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;
        
        if(p != null && q == null)
            return false;
        
        if(p == null && q != null)
            return false;
        
        boolean validateOneSide = isSame(p.left, q.left);
        boolean validateOther = isSame(p.right, q.right);
        
        return p.val == q.val && validateOneSide && validateOther;
    }
}