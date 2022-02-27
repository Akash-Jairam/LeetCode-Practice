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
        // if the root is null, add a "X,"
        // Make a recursive call to root.left
        // Make a recrusive call to root.right
        // Return root.val + root.left + root.right
        if(root == null)
            return "X,";
        
        String leftVal = serialize(root.left);
        String rightVal = serialize(root.right);
        
        return String.valueOf(root.val) + "," + leftVal + rightVal;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Create a queue
        // Split the string according to commas and add it to the queue
        // Call our helper method
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    
    public TreeNode deserializeHelper(Queue<String> queue){
        String currentVal = queue.poll();
        if(currentVal.equals("X")){
            return null;
        }
        
        TreeNode current = new TreeNode(Integer.parseInt(currentVal));
        current.left = deserializeHelper(queue);
        current.right = deserializeHelper(queue);
        return current;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));