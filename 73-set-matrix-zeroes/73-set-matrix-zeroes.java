class Solution {
    public void setZeroes(int[][] matrix) {
        // Create a variable to serve as the flag for whether to set column 0 to 0s
        // Iterate through our matrix, starting from row 0 and col 1
        // If an element is 0, update the beginning of that row and the beginning of that col to 0
        // Iterate through the matrix from the bottom up and if the row head or col head of a given element is 0, set that element to 0
        // If col 0 is enabled, set the current row and column 0 / beginning of current row to 0
        boolean column0Flag = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; ++i){
            if(matrix[i][0] == 0)
                column0Flag = true;
            for(int j = 1; j < col; ++j){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = row - 1; i >= 0; --i){
            for(int j = col - 1; j >= 1; --j){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(column0Flag)
                matrix[i][0] = 0;
        }
    }
}