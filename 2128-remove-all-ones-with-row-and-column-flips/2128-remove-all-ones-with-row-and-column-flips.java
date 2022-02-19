class Solution {
    public boolean removeOnes(int[][] grid) {
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == 1){
                    if(i == 0){
                        flipColumn(grid, j);
                    } else{
                        flipRow(grid[i]);
                    }
                }
            }
        }
        
        for(int[] row : grid){
            for(int num : row){
                if(num == 1)
                    return false;
            }
        }
        
        return true;
    }
    
    public void flipColumn(int[][] grid, int column){
        for(int i = 0; i < grid.length; ++i){
            grid[i][column] = grid[i][column] == 0 ? 1 : 0;
        }
    }
    
    public void flipRow(int[] grid){
        for(int i = 0; i < grid.length; ++i){
            grid[i] = grid[i] == 0 ? 1 : 0;
        }
    }
}