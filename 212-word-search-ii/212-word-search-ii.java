class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        TrieNode root = new TrieNode();
        for(String word : words){
            buildTrie(root, word);
        }
        
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                char c = board[i][j];
                if(root.children[c - 'a'] != null){
                    dfs(board, i, j, res, root, visited);
                }
            }
        }
        return res;
    }
    
    
    public void dfs(char[][] board, int i, int j, List<String> res, TrieNode it, boolean[][] visited){
        if(it.word != ""){
           res.add(it.word);
           it.word = "";
        }
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j])
            return;
        
        char c = board[i][j];
        if(it.children[c - 'a'] == null)
            return;
        
        it = it.children[c - 'a'];
        visited[i][j] = true;
        dfs(board, i + 1, j, res, it, visited);
        dfs(board, i - 1, j, res, it, visited);
        dfs(board, i, j + 1, res, it, visited);
        dfs(board, i, j - 1, res, it, visited);
        
        visited[i][j] = false;
    }
    public void buildTrie(TrieNode root, String s){
        TrieNode it = root;
        
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(it.children[c - 'a'] == null)
                it.children[c - 'a'] = new TrieNode();
            
            it = it.children[c - 'a'];
        }
        it.word = s;
    }
    
    class TrieNode{
        String word = "";
        TrieNode[] children = new TrieNode[26];
    }
}