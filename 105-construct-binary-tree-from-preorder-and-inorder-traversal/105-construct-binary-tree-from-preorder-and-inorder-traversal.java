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
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i){
            map.put(inorder[i], i);
        }
        int end = preorder.length - 1;
        return dfs(0, end, preorder, map);
    }
    
    public TreeNode dfs(int start, int end, int[] pre, HashMap<Integer, Integer> map){
        if(start > end)
            return null;
        
        TreeNode curr = new TreeNode(pre[index]);
        ++index;
        int mid = map.get(curr.val);
        curr.left = dfs(start, mid - 1, pre, map);
        curr.right = dfs(mid + 1, end, pre, map);
        
        return curr;
    }
}