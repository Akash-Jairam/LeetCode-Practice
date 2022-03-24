class Solution {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights == null || heights.length == 0 || heights[0].length == 0)
            return res;
        
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic =  new boolean[row][col];
        
        for(int i = 0; i < row; ++i){
            dfs(i,0, heights, -1, pacific);
            dfs(i, col - 1, heights, -1, atlantic);
        }
        
        for(int i = 0; i < col; ++i){
            dfs(0, i, heights, -1, pacific);
            dfs(row -1, i, heights, -1, atlantic);
        }
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(List.of(i,j));
            }
        }
        
        return res;
    }
    
    public void dfs(int row, int col, int[][] heights, int prevHeight, boolean[][] ocean){
        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length)
            return;
        
        if(prevHeight > heights[row][col] || ocean[row][col])
            return;
        
        ocean[row][col] = true;
        for(int[] dir : directions){
            dfs(row + dir[0], col + dir[1], heights, heights[row][col], ocean);
        }
    }
}