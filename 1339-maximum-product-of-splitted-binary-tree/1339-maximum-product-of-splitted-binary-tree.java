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
    public int maxProduct(TreeNode root) {
        long sum = findSum(root);
        long[] res = new long[]{sum, 0};
        findMaxProduct(root, res);
        return (int) (res[1] % (1e9 + 7));
    }
    
    public long findMaxProduct(TreeNode root, long[] res){
        if(root == null)
            return 0;
        
        long left = findMaxProduct(root.left, res);
        long right = findMaxProduct(root.right, res);
        long curr = left + root.val + right;
        res[1] = Math.max(res[1], curr * (res[0] - curr));
        return curr;
    }
    
    public long findSum(TreeNode root){
        if(root == null)
            return 0;
        
        return findSum(root.left) + root.val + findSum(root.right);
    }
}