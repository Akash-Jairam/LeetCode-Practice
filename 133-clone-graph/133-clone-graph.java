/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        HashMap<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val));
        
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            
            for(Node neighbor: curr.neighbors){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }
        
        return visited.get(node);
    }
}