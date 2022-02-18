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
        // Create a function that will accept a node, a target value and a stringbuilder
        // This function will traverse through the tree using the given node until it finds the target while updating the stringbuilder in the process
        // We will create two string builders and call the search function twice to find the locations of both the start and destination values
        // We will compare these two strings and find the index of last common character
        // We will use the index of the last common character to generate our return value
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        findNode(root, startValue, start);
        findNode(root, destValue, end);
        int minLength = Math.min(start.length(), end.length());
        int index = 0;
        while(index < minLength && start.charAt(start.length() - index -1) == end.charAt(end.length() - index -1))
           index++;
        
        
        return "U".repeat(start.length()-index) + end.reverse().toString().substring(index);
    }
    
    public boolean findNode(TreeNode node, int target, StringBuilder sb){
        if(node.val == target)
            return true;
        
        if(node.left != null && findNode(node.left, target, sb)){
            sb.append("L");
            return true;
        }
        
        if(node.right != null && findNode(node.right, target, sb)){
            sb.append("R");
            return true;
        }
        
        return false;
    }
}