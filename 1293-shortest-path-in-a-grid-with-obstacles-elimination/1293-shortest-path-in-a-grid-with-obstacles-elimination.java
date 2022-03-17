class Solution {
    public int shortestPath(int[][] grid, int k) {
        if(grid.length == 0)
            return -1;
        
        
        int[][] directions = new int[][]{{-1, 0}, {1,0}, {0, -1}, {0, 1}};
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k+1];
        int rowLimit = grid.length;
        int colLimit = grid[0].length;
        // Create an array of directions to track up, down, left or right
        // Create a queue to iterate through our graph
        // Add 0, 0, k as an array to our queue
        // While our queue is not empty
        // Get the current size of the queue
        // Iterate through the queue according to its current size
        // Take the number and update it based on the directions
        // Check to see if it the direction is valid and if the queue has not been visited before
        // Also check to see if we reach the end, if so, return our path, 
        // Check to see if the current node is an obstacle and remove k if k > 0 before adding to the queue
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, k});
        int steps = 0;
        visited[0][0][k] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                int[] curr = queue.poll();
                if(curr[0] == rowLimit -1 && curr[1] == colLimit -1)
                    return steps;
                for(int[] dir : directions){
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];
                    int kCount = curr[2];
                    if(row >= 0 && row < rowLimit && col >= 0 && col < colLimit){
                        if(grid[row][col] == 0 && visited[row][col][kCount] == false){
                            queue.offer(new int[]{row, col, kCount});
                            visited[row][col][kCount] = true;
                        } else if(grid[row][col] == 1 && kCount > 0 && visited[row][col][kCount-1] == false){
                            queue.offer(new int[]{row, col, kCount-1});
                            visited[row][col][kCount-1] = true;
                        }
                    }
                }
            }
            ++steps;

        }
        return -1;
    }
}