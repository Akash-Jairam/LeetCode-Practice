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
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    
    public int traverse(TreeNode node, List<List<Integer>> result){
        if(node == null)
            return -1;
        
        int leftLevel = traverse(node.left, result);
        int rightLevel = traverse(node.right, result);
        
        int level = Math.max(leftLevel, rightLevel) + 1;
        if(result.size() <= level)
            result.add(new ArrayList<>());
        
        result.get(level).add(node.val);
        return level;
    }
}