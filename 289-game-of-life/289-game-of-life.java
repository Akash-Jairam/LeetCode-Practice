class Solution {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)
            return;
        int[][] res = new int[board.length][board[0].length];
        int row = board.length;
        int col = board[0].length;
        
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                check(res, board, i, j, row, col);
            }
        }
        
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                board[i][j] = res[i][j];
            }
        }
    }
    
    public void check(int[][] res, int[][] board, int row, int col, int rowLimit, int colLimit){
        int count = 0;
        
        for(int[] dir : directions){
            int currRow = dir[0] + row;
            int currCol = dir[1] + col;
            if(currRow < 0 || currRow >= rowLimit || currCol < 0 || currCol >= colLimit)
                continue;
            if(board[currRow][currCol] == 1) ++count;
        }
        
        if(board[row][col] == 1){
            if(count < 2)
                res[row][col] = 0;
            else if(count < 4)
                res[row][col] = 1;
            else
                res[row][col] = 0;
        } else{
            if(count == 3)
                res[row][col] = 1;
            else
                res[row][col] = 0;
        }
    }
}