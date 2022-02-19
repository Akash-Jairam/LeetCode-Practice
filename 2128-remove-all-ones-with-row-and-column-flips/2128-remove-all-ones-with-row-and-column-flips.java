class Solution {
    public boolean removeOnes(int[][] grid) {
        boolean columnsFlipped = false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j ){
                if(grid[i][j] == 1){
                    if(i != 0){
                        flipRow(grid[i]);
                    } else{
                        flipColumn(grid, i, j);
                    }
                }
            }
        }
        
        for(int[] array : grid){
            for(int num : array){
                if(num == 1)
                    return false;
            }
        }
        
        return true;
    }
    
    public void flipColumn(int[][] grid, int row, int column){
        for(int i = 0; i < grid.length; ++i ){
            grid[i][column] = grid[i][column] == 0 ?  1 :  0;
        }
    }
    
    public void flipRow(int[] row){
        for(int i = 0; i < row.length; ++i){
            row[i] = row[i] == 0 ? 1 : 0;
        }
    }
}