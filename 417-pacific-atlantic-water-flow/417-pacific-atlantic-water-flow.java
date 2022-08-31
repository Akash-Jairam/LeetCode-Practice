class Solution {
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Create a list of lists to hold our results
        // Do a null check and return list of lists if needed
        //  Get the row and column limits of the given graph
        // Create  boolean arrays using the limits to track whether we can reach both oceans
        // Iterating through each row, We'll call our bfs function and pass in the graph, the curr row, 0 or column limit depending on which ocean we are tracking and the specific ocean array
        // Do the same but for each column
        // Iterate through each individual element of our graph and check to see if the binary flags for both arrays are true. If they are, add them to our result
        List<List<Integer>> res = new ArrayList<>();
        if(heights == null || heights.length == 0)
            return res;
        
        int row = heights.length, col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        
        for(int i = 0; i < row; ++i){
            dfs(heights, i, 0, -1, pacific);
            dfs(heights, i, col-1, -1, atlantic);
        }
        
        for(int i = 0; i < col; ++i){
            dfs(heights, 0, i, -1, pacific);
            dfs(heights, row-1, i, -1, atlantic);
        }
        
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(List.of(i, j));
            }
        }
        
        return res;
    }
    
    public void dfs(int[][] heights, int row, int col, int prevHeight, boolean[][] ocean){
        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length)
            return;
        
        if(prevHeight > heights[row][col] || ocean[row][col])
            return;
        
        ocean[row][col] = true;
        
        for(int[] dir : directions){
            dfs(heights, row + dir[0], col + dir[1], heights[row][col], ocean);
        }
    }
}