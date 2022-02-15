class Solution {
    public int shortestPath(int[][] grid, int k) {
        // Get dimensions of grid
        int rowSize = grid.length; int columnSize = grid[0].length;
        
        // Create array to track possible directions
        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        
        boolean[][][] visited = new boolean[rowSize][columnSize][k+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,k});
        int steps = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int w = 0; w< size; ++w){
                int[] curr = queue.poll();
                if(curr[0] == rowSize-1 && curr[1] == columnSize-1)
                    return steps;
                for(int[] dir : directions){
                    int i = curr[0] + dir[0];
                    int j = curr[1] + dir[1];
                    int limit = curr[2];
                    if(i >= 0 && i < rowSize && j >= 0 && j < columnSize){
                        if(grid[i][j] == 0 && visited[i][j][limit] == false){
                            queue.offer(new int[]{i, j, limit});
                            visited[i][j][limit] = true;
                        } else if(grid[i][j] == 1 && limit > 0 && visited[i][j][limit-1] == false){
                            queue.offer(new int[]{i, j, limit - 1});
                            visited[i][j][limit-1] = true;
                        }
        
                    }
                }
            }
           
            steps++;
        }
        return -1;
    }
}