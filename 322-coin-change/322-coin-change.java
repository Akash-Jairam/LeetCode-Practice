class Solution {
    public int coinChange(int[] coins, int amount) {
        // Bottom up dp approach
        // Create dp array starting from 0 up to the given amt
        // Fill array with amount + 1 as the value of its indices
        // Iterate through dp array and coins array to set the min number of coins
        // Check if the value at the amount index is not equal to amount plus one
        // if true, return value
        // Return -1
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 1; i <= amount; ++i){
            for(int j = 0; j < coins.length; ++j){
                if(coins[j] <=  i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }else
                    break;
            }
        }
        return dp[amount] == amount +1 ? -1 : dp[amount];
    }
}