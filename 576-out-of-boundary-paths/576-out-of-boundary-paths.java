class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove <= 0)
            return 0;
        
        final int MOD = (int)Math.pow(10, 9) + 7;
        
        int[][] count = new int[m][n];
        count[startRow][startColumn] = 1;
        int res = 0;
        
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        for(int step = 0; step < maxMove; ++step){
            int[][] temp = new int[m][n];
            for(int i = 0; i < m; ++i){
                for(int j = 0; j < n; ++j){
                    for(int[] dir : dirs){
                        int currRow = i + dir[0];
                        int currCol = j + dir[1];
                        
                        if(currRow < 0 || currRow >= m || currCol < 0 || currCol >= n){
                            res = (res + count[i][j]) % MOD;
                        } else {
                            temp[currRow][currCol] = (temp[currRow][currCol] + count[i][j]) % MOD;
                        }
                    }
                }
            }
            count = temp;
        }
        
        return res;
    }
}