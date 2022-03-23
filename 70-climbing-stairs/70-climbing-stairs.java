class Solution {
    public int climbStairs(int n) {
        // Use a bottom up approach
        // If n is 0, there are no stairs so it will only take one step to get to the top
        // We will find all the differnent ways from 1 to n
        // dp[n] = dp[n-2] + dp[n-1]
        // Then we'll just return n
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        
        for(int i = 2; i <= n; ++i){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}