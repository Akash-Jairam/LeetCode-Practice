/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < size; ++i){
                Node curr = queue.poll();
                currLevel.add(curr.val);
                for(Node child : curr.children){
                    queue.offer(child);
                }
            }
            res.add(currLevel);
        }
        
        return res;
    }
}