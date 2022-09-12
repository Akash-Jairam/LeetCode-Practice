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
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        String[] split = data.split(",");
        for(String s : split) queue.offer(s);
        return buildTree(queue);
    }
    
    public TreeNode buildTree(Queue<String> queue){
        if(queue.isEmpty()) return null;
        String curr = queue.poll();
        if(curr.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(curr));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
    
    public void helper(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null,");
            return;
        }
        
        sb.append(node.val + ",");
        helper(node.left, sb);
        helper(node.right, sb);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));