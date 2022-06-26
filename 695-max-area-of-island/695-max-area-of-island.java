class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }
        
        return max;
    }
    
    public int dfs(int row, int col, int[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }
        
        grid[row][col] = 0;
        
        int left = dfs(row, col -1, grid);
        int right = dfs(row , col + 1, grid);
        int up = dfs(row - 1, col, grid);
        int down = dfs(row + 1, col, grid);
        
        return left + right + up + down + 1;
    }
}