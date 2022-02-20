class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] move = new int[4][2];
        move[0] = new int[]{0, -1};
        move[1] = new int[]{0, 1};
        move[2] = new int[]{-1, 0};
        move[3] = new int[]{1, 0};
        boolean[][][]  visited= new boolean[grid.length][grid[0].length][k+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,k});
        int rowLimit = grid.length;
        int columnLimit = grid[0].length;
        int count = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int w = 0; w < size; ++w){
                int[] current = queue.poll();
                if(current[0] == rowLimit -1  && current[1] == columnLimit - 1)
                    return count;
                for(int[] dir : move){
                    int row = current[0] + dir[0];
                    int column = current[1] + dir[1];
                    int limit = current[2];
                    if(row >= 0 && row < rowLimit && column >= 0 && column < columnLimit){
                        if(grid[row][column] == 0 && visited[row][column][limit] == false){
                            queue.offer(new int[] {row, column, limit});
                            visited[row][column][limit] = true;
                        } else if(grid[row][column] == 1 && limit > 0 && visited[row][column][limit-1] == false){
                            queue.offer(new int[]{row, column, limit-1});
                            visited[row][column][limit-1] = true; 
                        }
                    }
                }
            }
            count++;
        }
        
        return -1;
    }
}