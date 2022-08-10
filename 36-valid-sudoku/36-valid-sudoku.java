class Solution {
    public boolean isValidSudoku(char[][] board) {
        int number;
        
        for(int i = 0; i < board.length; ++i){
            boolean[] checkRow = new boolean[10];
            boolean[] checkCol = new boolean[10];
            boolean[] checkBox = new boolean[10];
            
            for(int j = 0; j < board[0].length; ++j){
                // Check row
                if(board[i][j] != '.'){
                    number = board[i][j] - '0';
                    if(checkRow[number])
                        return false;
                    checkRow[number] = true;
                }
                
                // Check Col
                if(board[j][i] != '.'){
                    number = board[j][i] - '0';
                    if(checkCol[number])
                        return false;
                    
                    checkCol[number] = true;
                }
                
                // Check Box
                int row = (i / 3 * 3) + j/3;
                int col = (i % 3 * 3) + j % 3;
                if(board[row][col]  != '.'){
                    number = board[row][col] - '0';
                    if(checkBox[number])
                        return false;
                    
                    checkBox[number] = true;
                }
            }
        }
        
        return true;
    }
}