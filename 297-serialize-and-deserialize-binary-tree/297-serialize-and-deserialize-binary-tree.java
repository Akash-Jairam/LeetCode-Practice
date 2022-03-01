/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "X,";
            
        String leftString = serialize(root.left);
        String rightString = serialize(root.right);
        
        return String.valueOf(root.val) + "," + leftString + rightString;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodesLeft = new LinkedList<>();
        nodesLeft.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodesLeft);
    }
    
    public TreeNode deserializeHelper(Queue<String> queue){
        String current = queue.poll();
        if(current.isEmpty() || current.equals("X"))
            return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(current));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));