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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zig = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> queue2 = new LinkedList<>();
            
            for(int i = 0; i < size; ++i){
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
                if(zig)
                    queue2.offer(node.val);
                else
                    queue2.addFirst(node.val);
            }
            result.add(queue2);
            zig = !zig;
            queue2 = new LinkedList<>();
        }
        
        return result;
    }
}