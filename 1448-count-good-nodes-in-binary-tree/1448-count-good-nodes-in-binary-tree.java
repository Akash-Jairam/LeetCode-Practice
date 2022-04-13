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
    public int goodNodes(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        
        return helper(root, set);
    }
    
    public int helper(TreeNode root, TreeSet<Integer> set){
        if(root == null)
            return count;
        
        
        Integer ceiling = set.ceiling(root.val);
        
        if((!set.isEmpty() && set.last() <= root.val ) || ceiling == null)
            ++count;
        
        set.add(root.val);
        TreeSet<Integer> leftSet = new TreeSet<>(set);
        TreeSet<Integer> rightSet = new TreeSet<>(set);
        helper(root.left, leftSet);
        return helper(root.right, rightSet);
    }
}