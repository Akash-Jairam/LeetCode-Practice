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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currDepth = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; ++i){
                TreeNode curr = queue.poll();
                if(currDepth == depth - 1){
                    TreeNode newLeft = new TreeNode(val);
                    TreeNode newRight = new TreeNode(val);
                    TreeNode oldLeft = curr.left;
                    TreeNode oldRight = curr.right;
                    curr.left = newLeft;
                    newLeft.left = oldLeft;
                    curr.right = newRight;
                    newRight.right = oldRight;
                } else{
                    if(curr.left != null)
                        queue.offer(curr.left);
                    
                    if(curr.right != null)
                        queue.offer(curr.right);
                }
            }
            
            if(currDepth == depth -1)
                return root;
            else
                ++currDepth;
        }
        
        return root;
    }
}