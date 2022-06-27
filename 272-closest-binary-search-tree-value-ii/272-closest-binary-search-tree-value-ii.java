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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer x, Integer y){
                double xDiff = Math.abs(x - target);
                double yDiff = Math.abs(y - target);
                if(yDiff > xDiff){
                    return 1;
                } else if(yDiff < xDiff)
                    return -1;
                else
                    return 0;
            }
        });
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode curr = queue.poll();
                pq.offer(curr.val);
                
                if(pq.size() > k)
                    pq.poll();
                
                if(curr.left != null)
                    queue.offer(curr.left);
                
                if(curr.right != null)
                    queue.offer(curr.right);
            }
        }
        
        res.addAll(pq);
        return res;
    }
}