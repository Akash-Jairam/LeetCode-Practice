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
    int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);
        return diameter;
    }
    
    public int findDiameter(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int leftLength = findDiameter(node.left);
        int rightLength = findDiameter(node.right);
        
        diameter = Math.max(diameter, leftLength + rightLength);
        
        return 1 + Math.max(leftLength, rightLength);
    }
}