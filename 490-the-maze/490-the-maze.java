class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            visited[curr[0]][curr[1]] = true;
            
            if(destination[0] == curr[0] && destination[1] == curr[1])
                return true;
            
            for(int[] dir : directions){
                int row = curr[0];
                int col = curr[1];
                
                while(isValid(maze, row+dir[0], col+dir[1])){
                    row += dir[0];
                    col += dir[1];
                }
                if(!visited[row][col])
                    queue.offer(new int[]{row, col});
            }
        }
        
        return false;
    }
    
    public boolean isValid(int[][] maze, int row, int col){
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 0;
    }
}