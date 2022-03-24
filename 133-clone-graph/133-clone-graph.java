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
        // We can do bfs traversal
        // Use a queue to traverse the graph
        // Use a map to hold the copied node and the original node as the value and key
        // Add the given node to the queue
        // Put the given node into the map and make a copy it it as the key
        // While our queue is not empty
        // Poll a node from the queue
        // Iterate through that queue's neighbors
        // Add that neighbor to the queue if it is not in the map yet and Put that neighbor into the map
        // Use the map to get the copy of the current node, that node's list of neighbors and add to it the copy of the current neighbor by pulling it from the map
        if(node == null)
            return node;
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> visited = new HashMap<>();
        queue.offer(node);
        visited.put(node, new Node(node.val));
        
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            for(Node neighbor : curr.neighbors){
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