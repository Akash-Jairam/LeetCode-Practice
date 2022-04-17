class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        // Create a flag to check to see if the first element in a given row is set to 0
        // If we encounter that, we set the flag to true
        // If we encounter a zero, set the first element in the corresponding row, and the ocrresponding col to 0
        // If
        boolean flag = false;
        
        for(int i = 0; i < row; ++i){
            if(matrix[i][0] == 0)
                flag = true;
            for(int j = 1; j < col; ++j){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        
        // Iterate through our matrix again
        // if the first element for a given row or column is equal to zero, we set the element at the current row and col to 0
        
        // If the  flag is set to true, set the first element of the column to 0
        for(int i = row - 1; i >= 0; --i){
            for(int j = col - 1; j >= 1; --j){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            
            if(flag)
                matrix[i][0] = 0;
        }
    }
}