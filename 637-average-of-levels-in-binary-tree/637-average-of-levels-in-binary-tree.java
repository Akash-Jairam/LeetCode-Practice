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
        List<Double> list = new ArrayList<Double>();
        if(root == null)
            return list;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        double runningTotal = 0;
        
        while(!queue.isEmpty()){
            // Gets the size of the queue before we loop over it
            int size = queue.size();
            
            // Iterates over tree nodes over that level
            for(int i = 0; i < size; ++i){
                // Take the current node
                TreeNode node = queue.poll();
                runningTotal +=node.val;
                
                // Add the left and right nodes to the queue thereby increasing its size
                if(node.left != null){
                    queue.add(node.left);
                }
                
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            
            // Determines the average of said level and resets the runningTotal
            list.add(runningTotal * 1.0 / size);
            runningTotal = 0;
            
        }
        
        return list;
    }
}