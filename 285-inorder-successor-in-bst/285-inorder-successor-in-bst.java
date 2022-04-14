/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode curr = queue.poll();
                if(curr.val > p.val){
                    if(res == null || (res != null && curr.val < res.val)){
                        res = curr;
                    }
                }
                    
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
        }
        
        return res;
    }
}