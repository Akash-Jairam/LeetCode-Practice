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
        findLCA(root, p, q);
        return lca;
    }
    
    public Integer findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return 0;
        
        int current = root.val == p.val || root.val == q.val ? 1 : 0;
        int findLeft = findLCA(root.left, p, q);
        int findRight = findLCA(root.right, p, q);
        
        if(current + findLeft + findRight >= 2 && lca == null){
            lca = root;
        }
        
        return current + findLeft + findRight;
    }
}