class Solution {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Node root = buildTrie(words);
        
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                dfs(board, i , j, root, res);
            }
        }
        
        return res;
    }
    
    public void dfs(char[][] board, int i, int j, Node node, List<String> res){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        
        char c = board[i][j];
        if(c == '*' || node.children[c - 'a'] == null)
            return;
        
        node = node.children[c - 'a'];
        if(node.word != null){
            res.add(node.word);
            node.word = null;
        }
        
        board[i][j] = '*';
        for(int[] dir : directions){
            dfs(board, i + dir[0], j + dir[1], node, res);
        }
        board[i][j] = c;
    }
    
    public Node buildTrie(String[] words){
        Node root = new Node();
        for(String word : words){
            Node it = root;
            for(char c : word.toCharArray()){
                int val = c - 'a';
                if(it.children[val] == null)
                    it.children[val] = new Node();
                it = it.children[val];
            }
            it.word = word;
        }
        
        return root;
    }
}

class Node{
    Node[] children;
    String word;
    
    public Node(){
        children = new Node[26];
    }
}