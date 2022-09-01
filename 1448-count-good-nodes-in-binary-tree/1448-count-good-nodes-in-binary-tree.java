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
    int count = 0;
    public int goodNodes(TreeNode root) {

        
        helper(root, Integer.MIN_VALUE);
        return count;
    }
    
    public void helper(TreeNode root, int prev){
        if(root == null)
            return;
        
        if(prev <= root.val)
            ++count;
        
        int max = Math.max(prev, root.val);
        helper(root.left, max);
        helper(root.right, max);
    }
}