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
// Create global variable with min integer value
        // If root is null, we return 0
        // We call our function with four args: currentNode, leftNode, rightNode, currentDiameter
        // If currentNode is null, we will return 0
        // We'll make a recursive call to leftNode and the RightNode.
        // We'll add these values to the current diameter and compare that with our global variable
        // Return 1 + the greater of the diameters of leftNode and Right node
class Solution {
    int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        findDiameter(root, 0);
        return diameter;
    }
    
    public int findDiameter(TreeNode root, int currentDiameter){
        if(root == null)
            return currentDiameter;
        
        int leftDiameter = findDiameter(root.left, currentDiameter);
        int rightDiameter = findDiameter(root.right, currentDiameter);
        
        diameter = Math.max(diameter, currentDiameter + leftDiameter + rightDiameter);
        
        return 1 + Math.max(leftDiameter, rightDiameter);
    }
}