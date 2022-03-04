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
        List<String> list = new LinkedList<>();
        serializeHelper(root, list);
        return String.join(",", list);
    }
    
    public void serializeHelper(Node node, List<String> list){
        if(node == null)
            return;
        
        list.add(String.valueOf(node.val));
        list.add(String.valueOf(node.children.size()));
    
        for(Node current : node.children){
            serializeHelper(current, list);
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.isEmpty())
            return null;
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    
    public Node deserializeHelper(Queue<String> queue){
        Node node = new Node( Integer.parseInt(queue.poll()), new ArrayList<>());
        int size = Integer.parseInt(queue.poll());
        for(int i = 0; i < size; ++i){
            node.children.add(deserializeHelper(queue));
        }
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));