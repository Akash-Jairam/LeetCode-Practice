class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0,1}, {0, -1} };
    public List<String> findWords(char[][] board, String[] words) {
        Node root = buildTrie(words);
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                char c = board[i][j];
                if(root.children[c - 'a'] != null){
                    traverse(board, i, j, root, res);
                }
            }
        }
        
        return res;
    }
    
    public void traverse(char[][] board, int i, int j, Node node, List<String> res){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*')
            return;
        
        char c = board[i][j];
        if(node.children[c - 'a'] == null)
            return;
        
        node = node.children[c - 'a'];
        
        if(node.word != null ){
            res.add(node.word);
            node.word = null;
        }
            
        
        
         
        
        board[i][j] = '*';
        
        for(int[] dir : directions){
            traverse(board, i + dir[0], j + dir[1], node, res);
        }
    
        board[i][j] = c;
    }
    
    public Node buildTrie(String[] words){
        Node root = new Node();
        for(String word : words){
            Node it = root;
            for(int i = 0; i < word.length(); ++i){
                int idx = word.charAt(i) - 'a';
                if(it.children[idx] == null)
                    it.children[idx] = new Node();
                it = it.children[idx];
            }
            it.word = word;
        }
        
        return root;
    }
}

class Node {
    Node[] children;
    String word;
    
    public Node(){
        this.children = new Node[26];
    }
}