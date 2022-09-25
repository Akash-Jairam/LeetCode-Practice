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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }
    
    public int traverse(TreeNode node, List<List<Integer>> res){
        if(node == null) return -1;
        
        int level = Math.max(traverse(node.left, res), traverse(node.right, res)) + 1;
        if(res.size() <= level){
            res.add(new ArrayList<>());
        }
        
        res.get(level).add(node.val);
        return level;
    }
}