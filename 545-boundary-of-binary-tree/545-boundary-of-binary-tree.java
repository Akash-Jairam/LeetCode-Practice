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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        res.add(root.val);
        findLeaf(root.left, res, true, false);
        findLeaf(root.right, res, false, true);
        return res;
        
    }
    
    public void findLeaf(TreeNode root, List<Integer> res, boolean isLeftLeaf, boolean isRightLeaf){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            res.add(root.val);
            return;
        }
        
        if(isLeftLeaf){
            res.add(root.val);
        }
        
        findLeaf(root.left, res, root.left != null && isLeftLeaf, root.right == null && isRightLeaf);
    
        findLeaf(root.right, res, root.left == null && isLeftLeaf, root.right != null && isRightLeaf );
        if(isRightLeaf){
            res.add(root.val);
        }
    }
}