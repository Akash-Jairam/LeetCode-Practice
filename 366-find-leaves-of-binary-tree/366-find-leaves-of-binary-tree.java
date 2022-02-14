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
        // Create a list of lists that will hold our results
        // Call our recursive function and give the root and list of lists as parameters
        // Return the result
        List<List<Integer>> result = new ArrayList<>();
        find(root, result);
        return result;
    }
    
    // If the root is null, return -1
    // Level will be the greater of the recursive call to the left subnode and the right subnode + 1
    // If the size of our result list is less than the level, add a new blank arraylist to our result list
    // We get the current level and add the current node to it
    public int find(TreeNode node, List<List<Integer>> result){
        if(node == null)
            return -1;
        
        int level = Math.max(find(node.left, result), find(node.right, result)) + 1;
        if(result.size() <= level)
            result.add(new ArrayList<>());
        
        result.get(level).add(node.val);
        return level;
    }
}