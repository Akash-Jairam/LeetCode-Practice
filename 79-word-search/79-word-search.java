class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if((board[i][j] == word.charAt(0)) && dfs(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, int row, int column, int count, String word){
        if(count == word.length())
            return true;
        
        if(row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != word.charAt(count))
            return false;
        
        char temp = board[row][column];
        board[row][column] = ' ';
        boolean found = dfs(board, row -1, column, count + 1, word) 
                        || dfs(board, row + 1, column, count+1, word)
                        || dfs(board, row, column-1, count+1, word)
                        || dfs(board, row, column+1, count + 1, word);
        board[row][column] = temp;
        return found;
    }
}