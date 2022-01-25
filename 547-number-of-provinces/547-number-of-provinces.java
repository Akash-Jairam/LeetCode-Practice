class Solution {
    public int findCircleNum(int[][] isConnected) {
       int count = 0;
       int[] visited = new int[isConnected.length];
       for(int i = 0; i < isConnected.length; ++i){
           if(visited[i] == 0){
               count++;
               dfs(isConnected, visited, i);
           }
       }
       return count;
    }
    
    public void dfs(int[][] array, int[] visited, int i){
        for(int j = 0; j < array.length; ++j){
            if(array[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(array, visited, j);
            }
        }
    }
}