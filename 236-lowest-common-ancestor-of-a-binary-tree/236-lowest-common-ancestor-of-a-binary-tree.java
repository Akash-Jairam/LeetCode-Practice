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
        // If we reach a node at the end of the tree or the lowest ancestor is already found, return 0;
        if(root == null || lowestAncestor != null)
            return 0;
        
        // Tracker which lets us know if p or q is found
        int r = ( root == p || root == q) ? 1 : 0;
        
        // Check to see if the other value is to the left or right of the tracker
        int left = setLowestAncestor(root.left, p, q);
        int right = setLowestAncestor(root.right, p, q);
        
        // If a node is found and we know the position of the other node, the lowest Ancestor must be the root.
        if(r + left + right >= 2 && lowestAncestor == null)
            lowestAncestor = root;
        
        return r + left + right;
    }
}