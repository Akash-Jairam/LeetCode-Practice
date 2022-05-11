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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        traverse(res, root);
        return res;
    }
    
    public void traverse(List<Integer> res, TreeNode root){
        if(root == null)
            return;
        
        res.add(root.val);
        if(root.left != null)
            traverse(res, root.left);
        
        if(root.right != null)
            traverse(res, root.right);
    }
}