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
    
    public int distributeCoins(TreeNode root) {
        int[] steps = new int[]{0};
        distribute(root, steps);
        return steps[0];
    }
    
    public int distribute(TreeNode node, int[] steps){
        if(node == null)
            return 0;
        
        int leftSteps = distribute(node.left, steps);
        int rightSteps = distribute(node.right, steps);
        
        steps[0] += (Math.abs(leftSteps) + Math.abs(rightSteps));
        return node.val + leftSteps + rightSteps -1;
    }
}