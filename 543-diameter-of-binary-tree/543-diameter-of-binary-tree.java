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
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return 0;
        find(root);
        return diameter;
    }
    
    public int find(TreeNode node){
        if(node == null )
            return 0;
        
        int findLeft = find(node.left);
        int findRight = find(node.right);
        diameter = Math.max(diameter, findLeft + findRight);
        
        int sublength;
        
            sublength = Math.max(findLeft, findRight);
        
        return 1 + sublength;
    }
    
    
}