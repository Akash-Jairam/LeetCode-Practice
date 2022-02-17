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
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        find(root, startValue, start);
        find(root, destValue, end);
        int i = 0, max_i = Math.min(end.length(), start.length());
    while (i < max_i && start.charAt(start.length() - i - 1) == end.charAt(end.length() - i - 1))
        ++i;
       
        return "U".repeat(start.length() - i) + end.reverse().toString().substring(i); 
    }
    
    public boolean find(TreeNode node, int val, StringBuilder sb){
        if(node.val == val)
            return true;
        
        if(node.left != null && find(node.left, val, sb)){
            sb.append("L");
        } else if(node.right != null && find(node.right, val, sb))
            sb.append("R");
        
        return sb.length() > 0;
    }
}