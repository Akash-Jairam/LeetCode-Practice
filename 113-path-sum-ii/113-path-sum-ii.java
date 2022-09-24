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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root != null)
            helper(root, 0, targetSum, new ArrayList<>(), res);
        return res;
    }
    
    public void helper(TreeNode node, int currSum, int target, List<Integer> list, List<List<Integer>> res){
        if(node == null){
            return;
        }
        
        list.add(node.val);
        currSum += node.val;
        if(node.left == null && node.right == null && currSum == target){
            res.add(list);
        }
        helper(node.left, currSum, target, new ArrayList<>(list), res);
        helper(node.right, currSum, target, new ArrayList<>(list), res);
    }
}