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
    public int countNodes(TreeNode root) {
        // Create pointers for our right and our left traversal
        // Go as far left as possible until right ptr is null while making sure to count the levels
        // If left still has ways to go, we make a recursive call
        // Return 2 to the power of count plus count nodes left
        if(root == null)
            return 0;
        
        TreeNode left = root;
        TreeNode right = root;
        int count = 0;
        
        while(right != null){
            ++count;
            left = left.left;
            right = right.right;
        }
        
        if(left != null){
            return  countNodes(root.left) + 1 + countNodes(root.right);
        }
        
        return (int)Math.pow(2, count) -1 ;
    }
}