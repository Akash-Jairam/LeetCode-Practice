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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<NodeInfo>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(root, map, 0, 0);
        
        for(List<NodeInfo> list : map.values()){
            Collections.sort(list, new NodeInfoComparator());
            List<Integer> curr = new ArrayList<>();
            for(NodeInfo ni : list){
                curr.add(ni.value);
            }
            res.add(curr);
        }
        return res;
    }
    
    public void helper(TreeNode node, TreeMap<Integer, List<NodeInfo>> map, int level, int col){
        if(node == null)
            return;
        
        if(!map.containsKey(col)){
            map.put(col, new ArrayList<>());
        }
        
        map.get(col).add(new NodeInfo(node.val, level, col));
        
        if(node.left != null){
            helper(node.left, map, level + 1, col -1);
        }
        
        if(node.right != null){
            helper(node.right, map, level + 1, col + 1);
        }
        
    }
    
    class NodeInfoComparator implements Comparator<NodeInfo>{
        public int compare(NodeInfo n1, NodeInfo n2){
            if(n1.level < n2.level) return -1;
            else if(n2.level < n1.level) return 1;
            else return n1.value - n2.value;
        }
    }
    class NodeInfo{
        int value;
        int level;
        int col;
        
        public NodeInfo(int value, int level, int col){
            this.value = value;
            this.level = level;
            this.col = col;
        }
    }
}