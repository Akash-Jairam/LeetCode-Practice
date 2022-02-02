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
 Iterate through entire tree and add each value to the the queue.
 Pop members of the queue until we reach the kth element
 * }
 */
class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y) -> Integer.compare(x,y));
    public int kthSmallest(TreeNode root, int k) {
        findSmallest(root);
        while(k != 1){
           pq.poll();
           k--;
        }            
        return pq.remove();
    }
    
    public void findSmallest(TreeNode node){
        if(node == null){
            return;
        }
        pq.add(node.val);
        findSmallest(node.left);
        findSmallest(node.right);
    }
}