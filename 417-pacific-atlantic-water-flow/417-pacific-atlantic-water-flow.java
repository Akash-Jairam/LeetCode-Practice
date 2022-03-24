class Solution {
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // We will use a dfs approach
        // First, we will create a list of lists to hold our results
        // We will perform null checks on our given array to ensure that it is not empty and return the empty list if it is
        // Create variables to track the row and the column limits
        // Create an array to track which nodes we have visited for both the pacific and atlantic ocean
        // Create an array that will hold all the possible directions we can move in
        // Loop through our array's rows and call dfs passing in the current row and column and the pacific or atlantic  array, -1 (the lowest possible height), and the height array
        // The start column for pacific ocean will be 0 and the start row for atlantic will be 1
        // Do the same for the columns where the start column for pacific is 0 and the oen for atlantic is the last one
        // Loop through the elements of our height array again and if both pacific visted and atlantic visited are true, we will add the list of that coordinate to our result
        List<List<Integer>> res = new ArrayList<>();
        if(heights == null || heights.length == 0 || heights[0].length == 0)
            return res;
        
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        
        for(int i = 0; i < row; ++i){
            dfs(heights, i, 0, -1,  pacific);
            dfs(heights, i, col-1, -1, atlantic);
        }
        
        for(int i = 0; i < col; ++i){
            dfs(heights, 0, i, -1, pacific);
            dfs(heights, row-1, i, -1, atlantic);
        }
        
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(List.of(i,j));
            }
        }
        
        return res;
    }
    
    public void dfs(int[][] heights, int row, int col, int currHeight, boolean[][] ocean ){
        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length)
            return;
        // Check to see if the given height is lower than the height of the given index
        if(currHeight > heights[row][col] || ocean[row][col])
            return;
        
        ocean[row][col] = true;
        
        for(int[] dir : directions){
            dfs(heights, row + dir[0], col + dir[1], heights[row][col], ocean);
        }
    }
}