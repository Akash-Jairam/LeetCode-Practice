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
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLowestCommonAncestor(root, p, q);
        return this.lca;
    }
    
    public int findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return 0;
        
        int findCurrent = (root.val == p.val || root.val == q.val) ?  1 : 0;
        int findLeft = findLowestCommonAncestor(root.left, p, q);
        int findRight = findLowestCommonAncestor(root.right, p, q);
        
        if(findCurrent + findLeft + findRight >= 2 && lca == null)
            lca = root;
        
        return findCurrent + findLeft + findRight;
    }
}