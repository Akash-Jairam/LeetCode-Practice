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
        
        return String.valueOf(root.val) + "," + leftString  + rightString;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
          queue.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    
    public TreeNode deserializeHelper(Queue<String> queue){
        String valueForNode = queue.poll();
        if(valueForNode.equals("X") || valueForNode.equals(""))
            return null;
        
        TreeNode left = deserializeHelper(queue);
        TreeNode right = deserializeHelper(queue);
        
        TreeNode current = new TreeNode(Integer.parseInt(valueForNode));
        current.left = left;
        current.right = right;
        
        return current;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));