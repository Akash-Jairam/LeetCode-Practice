class Solution {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, k});
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                int[]curr = queue.poll();
                if(curr[0] == m - 1 && curr[1] == n - 1) return steps;
                
                for(int[] dir : directions){
                    int row = curr[0] + dir[0], col = curr[1] + dir[1], elims = curr[2];
                    if(row >= 0 && row < m && col >= 0 && col < n){
                        elims -= grid[row][col];
                        if(elims >= 0 && !visited[row][col][elims]){
                            visited[row][col][elims] = true;
                            queue.offer(new int[]{row, col, elims});
                        }
                    }
                }
            }
            ++steps;
        }
        
        return -1;
    }
}