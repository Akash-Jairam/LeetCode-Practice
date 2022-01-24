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
    TreeNode lowestCommonAncestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return lowestCommonAncestor;
    }
    
    public int findLCA(TreeNode node, TreeNode p, TreeNode q){
        if(node == null)
            return 0;
        
        int findCurrent = (node.val == p.val || node.val == q.val) ? 1 : 0;
        int findLeft = findLCA(node.left, p, q);
        int findRight = findLCA(node.right, p, q);
        
        if(lowestCommonAncestor == null && findCurrent + findLeft + findRight >= 2){
            lowestCommonAncestor = node;
        }
        
        return findCurrent + findLeft + findRight;
    }
}