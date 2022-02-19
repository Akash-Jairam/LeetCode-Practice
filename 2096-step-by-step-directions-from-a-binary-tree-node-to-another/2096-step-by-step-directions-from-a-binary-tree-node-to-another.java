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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Create two string builders, one to track the traversal to find the start val
        // And one to track the traversal to find the destination value
        // Create a function while will find a value and update the given stringbuilder
        // Take the two string builders and iterate through them from right to left (since the first root visited will be the last character) until we get to the last common character
        // Our traversal from the start to the lowest common ancestor will be the U times the distance between the start and the LCA
        // Our traversal from the lca to the destination, will be the substring of the reverse of the stringbuilder from the lca index (since we are going top down)
        StringBuilder begin = new StringBuilder();
        StringBuilder end = new StringBuilder();
        findNode(root, startValue, begin);
        findNode(root, destValue, end);
        int limit = Math.min(begin.length(), end.length());
        int lca = 0;
        while(lca < limit && begin.charAt(begin.length() -1- lca) == end.charAt( end.length()-1  - lca)){
            lca++;
        }
        
        
        return "U".repeat(begin.length() - lca) + end.reverse().toString().substring(lca);
    }
    
    // Find Node
    // If the node val == the target, we return true
    // We perform null checks on the left and right nodes before making a recursive call
    // We append L or R based on if either recursive call returned true
    public boolean findNode(TreeNode node, int target, StringBuilder sb){
        if(node.val == target)
            return true;
        
        if(node.left != null && findNode(node.left, target, sb)){
            sb.append("L");
            return true;
        }else if(node.right != null && findNode(node.right, target, sb)){
            sb.append("R");
            return true;
        }
        
        return false;
    }
}