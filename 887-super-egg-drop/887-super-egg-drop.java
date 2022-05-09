class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n + 1][k+1];
        int steps = 0;
        
        while(dp[steps][k] < n){
            ++steps;
            for(int i = 1; i <= k; ++i){
                dp[steps][i] = dp[steps-1][i] + dp[steps-1][i-1] + 1;
            }
        }
        
        return steps;
    }
}