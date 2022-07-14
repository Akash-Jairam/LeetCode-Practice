class Solution {
    public boolean isValidSudoku(char[][] board) {
        int number;
        for(int row = 0; row < board.length; ++row){
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            boolean[] cell = new boolean[9];
            
            for(int col = 0; col < board[0].length; ++col){
                
                if(board[row][col] != '.'){
                    number = board[row][col] - '1';
                    
                    if(rowCheck[number])
                        return false;
                    rowCheck[number] = true;
                }
                
                if(board[col][row] != '.'){
                    number = board[col][row] - '1';
                    
                    if(colCheck[number])
                        return false;
                    colCheck[number] = true;
                }
                
                int rowBox = row / 3 * 3 + col/3;
                int colBox = row % 3 * 3 + col % 3;
                if(board[rowBox][colBox] != '.'){
                    number = board[rowBox][colBox] - '1';
                    
                    if(cell[number])
                        return false;
                    cell[number] = true;
                }
            }
        }
        
        return true;
    }
}