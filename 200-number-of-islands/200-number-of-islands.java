class Solution {
    public int numIslands(char[][] grid) {
        // Create a variable to count the number of islands
        // Iterate through each element in our grid
        // If we spot an island, we perform bfs on the surrounding elements to flip that island thereby ensuring that it will not be counted again
        int count = 0;
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[i].length; ++j){
                if(grid[i][j] == '1'){
                    ++count;
                    dfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0'){
            return;
        }
        // Check to see if the row or column is our of bounds or if the current element is 0 (meaning we are off the island)
        
        grid[row][col] = '0';
        
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col -1);
    }
}