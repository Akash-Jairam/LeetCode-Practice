class Solution {
    public int climbStairs(int n) {
        // Use a bottom up approach
        // Create our array with n+1 size
        // Set index 0 to 0 and index 1 to 1 since if the staircase has no steps or 1 step, you can just take a single step to reach the top
        // Iterate through the array from 2 to n
        // Assign the value at the current index to the sum of the values at the current index -1 and the value at the current index - 2;
        // Return array[n]
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; ++i){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}