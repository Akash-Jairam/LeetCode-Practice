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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root == null){
            return list;
        }
        
        queue.add(root);
        double sum = 0;
        
        while(!queue.isEmpty()){
        int size = queue.size();
        for(int i = 0; i < size; ++i){
            TreeNode node = queue.poll();
            sum += node.val;
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
            list.add(sum / size);
            sum = 0;
        }
        
        return list;
    }
}