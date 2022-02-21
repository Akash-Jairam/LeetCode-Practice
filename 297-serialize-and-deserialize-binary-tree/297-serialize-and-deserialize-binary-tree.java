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
        // If the node is null, place a 'null,'
        // Create a variable called leftString and assign to it the result of serialize(root.left)
        // Create a variable called rightString and assing to it the result of serialize(root.right)
        // return the string of root.val + comma + leftString + comma+ right String
        if(root == null)
            return "null,";
        
        String leftString = serialize(root.left);
        String rightString = serialize(root.right);
        
        return String.valueOf(root.val) + "," + leftString  + rightString;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Create a queue 
        // Assign to the queue the values of the string split into an array  by the commas and converted to a list
        // return the result of calling the deserialize helper method on this queue
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    
    public TreeNode deserializeHelper(Queue<String> queue){
        String current = queue.poll();
        if(current == null || current.equals("null")){
            return null;
        }
        
        TreeNode leftNode = deserializeHelper(queue);
        TreeNode rightNode = deserializeHelper(queue);
        
        TreeNode currentNode = new TreeNode(Integer.parseInt(current));
        currentNode.left = leftNode;
        currentNode.right = rightNode;
        
        return currentNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));