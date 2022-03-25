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
        // Use bfs
        // Create a queue to hold our results
        // Create a map to map each node to its copy
        // Add the current node to the queue
        // Add the current node and a copy of it to the map
        // While the queue is not empty
        // Poll the current node
        // Iterate through that node's neighbors
        // If the map does not contain that node, add it and make a copy
        // Add the node to the queue
        // Using the current node, get a reference to the copy and add the copy you made to its neighbors
        if(node == null)
            return node;
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();
        queue.offer(node);
        map.put(node, new Node(node.val));
        
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            
            for(Node neighbor : curr.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val));
                                    queue.offer(neighbor);

                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
}