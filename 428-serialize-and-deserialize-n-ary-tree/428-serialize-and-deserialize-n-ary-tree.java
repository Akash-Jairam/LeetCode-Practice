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

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        // Create an ArrayList
        // Call the serializehelper function passing the root and the arraylist
        // Return string.join comma and arraylist
        ArrayList<String> nodes = new ArrayList<>();
        serializeHelper(root, nodes);
        return String.join(",", nodes);
    }
    
    public void serializeHelper(Node node, ArrayList<String> list){
        if(node == null)
            return;
        String val = String.valueOf(node.val);
        String size = String.valueOf(node.children.size());
        list.add(val);
        list.add(size);
        for(Node current : node.children){
            serializeHelper(current, list);
        }
        
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.isEmpty())
            return null;
        // Split the string by the commas and add it to a queue
        // Call our helper method and pass the queue as a parameter
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    
    public Node deserializeHelper(Queue<String> queue){
        Node parent = new Node();
        String current = queue.poll();
        String currentSize = queue.poll();
        parent.val = Integer.parseInt(current);
        parent.children = new ArrayList<Node>(Integer.parseInt(currentSize));
        for(int i = 0; i < Integer.parseInt(currentSize); ++i){
            parent.children.add(deserializeHelper(queue));
        }
        
        return parent;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));