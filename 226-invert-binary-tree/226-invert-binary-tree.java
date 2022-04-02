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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        
        TreeNode temp = root.left;
        if(temp != null){
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        } else {
            root.left = root.right;
            root.right = null;
            invertTree(root.left);
        }
        
        return root;
    }
}