class Solution {
    public int cherryPickup(int[][] grid) {
        // Create a three dimensional array to track the maximum possible paths
        // Set every value to -1
        // Set the 0, grid.length 'th value to the values at the top left and top right of the grid
                // Take note of the previous value which is at row[i-1][col1][col2]
        // Iterate through the grid starting from index 1 (second row)
        // Create an array to keep track of our possible choices
        // Iterate through column 1 (for the first robot) 
        // Iterate through our possible choices to generate a choice for our first robot
        // In a nested loop do the same for our second robot
        // Set dp[i][col1][col2] to the max of the current value and, if grid[col1] == grid[col2], grid[col1] else grid[col1] + grid[col2]
        // Update the max to the current max or dp[i][col1][col2]
        int row = grid.length;
        int col = grid[0].length;
        int[] dir = new int[] {-1, 0, 1};
        int[][][] dp = new int[row][col][col];
        
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                for(int k = 0; k < col; ++k){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        int col1 = 0;
        int col2 = col-1;
        dp[0][col1][col2] = grid[0][col1] + grid[0][col2];
        int max = dp[0][col1][col2];
        
        for(int i = 1; i < row; ++i){
            for(int c1 = 0; c1 < col; ++c1){
                for(int c2 = 0; c2 < col; ++c2){
                    int prev = dp[i-1][c1][c2];
                    // Ensures that this cell is ready to be visited by checking to see if the previous cell was visited
                    if(prev >= 0){
                        for(int d1 : dir){
                            col1 = c1 + d1;
                            for(int d2 : dir){
                                col2 = c2 + d2;
                                if(inRange(col1, col) && inRange(col2, col)){
                                    dp[i][col1][col2] = Math.max(dp[i][col1][col2], prev+(col1 == col2 ? grid[i][col1] : (grid[i][col1] + grid[i][col2])));
                                    max = Math.max(dp[i][col1][col2], max);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return max;
    }
    
    public boolean inRange(int col, int limit){
        return col >= 0 && col < limit;
    }
}