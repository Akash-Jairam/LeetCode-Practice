class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        
        for(int i = 0; i < size; ++i){
            for(int j = i; j < size; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int[] row : matrix){
            int start = 0;
            int end = row.length - 1;
            while(start < end){
                int temp = row[start];
                row[start] = row[end];
                row[end] = temp;
                ++start;
                --end;
            }
        }
    }
}