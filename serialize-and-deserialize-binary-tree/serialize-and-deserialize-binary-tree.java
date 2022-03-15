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
        // If root is equal to null, append a "X,"
        // Assign the left subtree to a string
        // Assing the right subtree to a string
        // Return the root.val converted to a string plus comma + left stirng +nright stirng
        if(root == null)
            return "X,";
        
        String leftSubTree = serialize(root.left);
        String rightSubTree = serialize(root.right);
        
        return String.valueOf(root.val) + "," + leftSubTree + rightSubTree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Create a Queue of TreeNodes/ Linked List to hold the data
        // SPlit data by the commas and add all of them to the queue
        // Return "call to helper method"
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    
    public TreeNode deserializeHelper(Queue<String> queue){
        // Poll the current string from the queue
        // If the current string is X, return null
        // Create a new treenode with the current string converted to int
        // Make a recursive call and assign the result to node.left
        // Do the same for node.right
        // Return the created node
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