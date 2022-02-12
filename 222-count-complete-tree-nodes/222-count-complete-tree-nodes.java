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
    public int countNodes(TreeNode root) {
        if(root == null)
            return count;
        traverse(root);
        return count;
    }
    
    public void traverse(TreeNode root){
        if(root == null)
            return;
        
        traverse(root.left);
        traverse(root.right);
        
        count++;
    }
}