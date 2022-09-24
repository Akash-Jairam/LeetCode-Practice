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
        findNode(root, startValue, start);
        
        StringBuilder end = new StringBuilder();
        findNode(root, destValue, end);
        
        int offset = 0;
        int limit = Math.min(start.length(), end.length());
        while(offset < limit && start.charAt(start.length() - 1 - offset) == end.charAt(end.length() - 1 - offset)){
            ++offset;
        }
        
        return "U".repeat(start.length() - offset) + end.reverse().toString().substring(offset);
    }
    
    public boolean findNode(TreeNode node, int val, StringBuilder sb){
        if(node.val == val) return true;
        
        if(node.left != null && findNode(node.left, val, sb)){
            sb.append("L");
            return true;
        } else if(node.right != null && findNode(node.right, val, sb)){
            sb.append("R");
            return true;
        }
        
        return false;
    }
}