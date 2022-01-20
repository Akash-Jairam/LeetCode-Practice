/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode lowestAncestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        
        setLowestAncestor(root, p, q);
        
        return this.lowestAncestor;
    }
    
    private int setLowestAncestor(TreeNode root, TreeNode p, TreeNode q){
        // Exit clause
       if(root == null || lowestAncestor != null)
           return 0;
        
        int r = (root.val == p.val || root.val == q.val) ? 1 : 0;
        
        int leftSide = setLowestAncestor(root.left, p,q);
        int rightSide = setLowestAncestor(root.right,p,q);
        
        // If both values have been found but the lowest ancestor is not, the lowest ancestor is the current node. If we don't set validate the lowestAncestor, we will get a highter ancestor.
        if(r + leftSide + rightSide >= 2 && lowestAncestor == null)
            lowestAncestor = root;
        
        return r + leftSide + rightSide;
    }
}