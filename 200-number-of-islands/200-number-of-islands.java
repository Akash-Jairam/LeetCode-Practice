class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == '0')
            return;
        
        grid[row][column] = '0';
        dfs(grid, row-1, column);
        dfs(grid, row+1, column);
        dfs(grid, row, column-1);
        dfs(grid, row, column+1);
    }
}