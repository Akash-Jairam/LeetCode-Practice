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
 
 * Create a global variable to store our answer
 * Call our find diameter function
 * return our answer
 * in our function, if node = null, return 0
 * find the left diameter and we find the right diameter
 * We compare the current diameter with the diameter of the current node
 * Return math.max(left, right) +1
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);
        return this.max;
    }
    
    public int findDiameter(TreeNode node){
        if(node == null)
            return 0;
        
        int leftDiameter = findDiameter(node.left);
        int rightDiameter = findDiameter(node.right);
        
        max = Math.max(max, leftDiameter+rightDiameter);
        return 1 + Math.max(leftDiameter, rightDiameter);
    }
}