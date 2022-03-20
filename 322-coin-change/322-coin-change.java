class Solution {
    public int coinChange(int[] coins, int amount) {
        // Use a bottom up approach 
        // Create an array to hold the optimal amount of coins from 0 to amount
        // Set all values to amount+1
        // Set index 0 to 0 
        // Use a for loop that goes from 1 to amount
        // Iterate through our array of coins
        // If that coin is less than or equal to the current amount
        // Set the value at the current index or amount to the smaller of the current value or 1 plus the value at the (current index - amount)
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        
        for(int i = 1; i <= amount; ++i){
            for(int coin : coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
                }
            }
        }
        
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}