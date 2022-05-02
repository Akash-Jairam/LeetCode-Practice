class Solution {
    public static final int max = (int) Math.pow(10, 9) + 7;
    
    public int knightDialer(int n) {
        long [][][] dp = new long[n+1][4][3];
        long steps = 0;
        
        for(int i = 0; i < 4; ++i){
            for(int j = 0; j < 3; ++j){
                steps = (steps + paths( i, j, dp, n)) % max;
            }
        }
        
        return (int) steps;
    }
    
    long paths(int i, int j, long[][][] dp, int n){
        if(i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1)){
            return 0;
        }
        
        if(n == 1)
            return 1;
        
        if(dp[n][i][j] > 0) return dp[n][i][j];
        
        dp[n][i][j] = paths(i - 1, j + 2, dp, n -1) % max +
                      paths(i - 1, j - 2, dp, n - 1) % max +
                      paths(i + 1, j + 2, dp, n - 1) % max +
                      paths(i + 1, j - 2, dp, n - 1) % max +
                      paths(i + 2, j - 1, dp, n - 1) % max +
                      paths(i + 2, j + 1, dp, n - 1) % max  +
                      paths(i - 2, j - 1, dp, n - 1) % max +
                      paths(i - 2, j + 1, dp, n - 1) % max;
        
        return dp[n][i][j];
    }
}