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
        findLowest(root, p, q);
        return this.lca;
    }
    
    public int findLowest(TreeNode node, TreeNode p, TreeNode q){
        if(node == null || lca != null){
            return 0;
        }
        
        int valFound = (node.val == p.val || node.val == q.val) ? 1 : 0;
        int valFoundOnLeft = findLowest(node.left, p, q);
        int valFoundOnRight = findLowest(node.right, p, q);
        
        if(valFound + valFoundOnLeft + valFoundOnRight >= 2 && lca == null){
            lca = node;
        }
        
        return valFound + valFoundOnLeft + valFoundOnRight;
    }
}